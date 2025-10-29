package com.fbs.notification_api.service;

import com.fbs.notification_api.dto.AirlineRegistrationReqDto;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@Slf4j
public class AppAdminNotificationService {
    private static final Logger log = LoggerFactory.getLogger(AppAdminNotificationService.class);


    JavaMailSender javaMailSender;
    TemplateEngine templateEngine;


    @Autowired
    public AppAdminNotificationService(JavaMailSender javaMailSender,TemplateEngine templateEngine){
        this.javaMailSender=javaMailSender;
        this.templateEngine=templateEngine;
    }
    public void sendAirlineRegistrationRequestNotification(AirlineRegistrationReqDto airlineRegistrationReqDto){

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);

        Context context=new Context();
        context.setVariable("airlineName",airlineRegistrationReqDto.getAirline().getAirlineName());
        context.setVariable("companyName",airlineRegistrationReqDto.getAirline().getCompanyName());
        context.setVariable("website",airlineRegistrationReqDto.getAirline().getWebsite());
        context.setVariable("employees",airlineRegistrationReqDto.getAirline().getEmployees());
        context.setVariable("totalFlights",airlineRegistrationReqDto.getAirline().getTotalFlights());
        context.setVariable("airlineAdminName",airlineRegistrationReqDto.getAirline().getAdmin().getName());
        context.setVariable("adminEmail",airlineRegistrationReqDto.getAirline().getAdmin().getEmail());
        context.setVariable("requestedTime",airlineRegistrationReqDto.getAirline().getCreatedAt().toString());
         

        String htmlContent = templateEngine.process("airline-registration-request",context);

        try{
            mimeMessageHelper.setTo(airlineRegistrationReqDto.getAdmin().getEmail());
            mimeMessageHelper.setSubject(airlineRegistrationReqDto.getAirline().getAirlineName()+" Registration Request");
//            mimeMessageHelper.setText("Hey, There is a new Registration Request");
            mimeMessageHelper.setText(htmlContent,true);
        }catch (Exception e){
            log.error(e.getMessage());
        }

        javaMailSender.send(mimeMessage);
    }
}
