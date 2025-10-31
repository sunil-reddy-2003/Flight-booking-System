package com.fbs.notification_api.service;

import com.fbs.notification_api.dto.AirlineRegistrationReqDto;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
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

        // Create an empty email message object (supports HTML emails)
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

// Helper class to easily set subject, receiver, and HTML body
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

// Create a context object to store values that will be inserted into the HTML template
        Context context = new Context();

// Add all airline details to the context → these will replace variables in the HTML file
        context.setVariable("airlineName", airlineRegistrationReqDto.getAirline().getAirlineName());
        context.setVariable("companyName", airlineRegistrationReqDto.getAirline().getCompanyName());
        context.setVariable("website", airlineRegistrationReqDto.getAirline().getWebsite());
        context.setVariable("employees", airlineRegistrationReqDto.getAirline().getEmployees());
        context.setVariable("totalFlights", airlineRegistrationReqDto.getAirline().getTotalFlights());

// Add airline admin details to the email template
        context.setVariable("airlineAdminName", airlineRegistrationReqDto.getAirline().getAdmin().getName());
        context.setVariable("adminEmail", airlineRegistrationReqDto.getAirline().getAdmin().getEmail());

// Add the time when airline registration was created
        context.setVariable("requestedTime", airlineRegistrationReqDto.getAirline().getCreatedAt().toString());

// Add accept/reject link URLs to display inside email
        context.setVariable("acceptLink", "http://localhost:8081/api/v1/central/airline/request/accept/" + airlineRegistrationReqDto.getAirline().getId().toString());
        context.setVariable("rejectLink", "http://localhost:8081/api/v1/central/airline/request/reject/" + airlineRegistrationReqDto.getAirline().getId().toString());

// Convert the HTML template (airline-registration-request.html) into final email HTML
        String htmlContent = templateEngine.process("airline-registration-request", context);

        try {
            // Set the receiver of the mail (system admin email)
            mimeMessageHelper.setTo(airlineRegistrationReqDto.getAppAdmin().getEmail());

            // Set the subject of the email
            mimeMessageHelper.setSubject(airlineRegistrationReqDto.getAirline().getAirlineName() + " Registration Request");

            // Set the email body and mark it as HTML content
            mimeMessageHelper.setText(htmlContent, true);

        } catch (Exception e) {
            // Log if anything goes wrong while preparing the email
            log.error(e.getMessage());
        }

// Finally send the email using the configured SMTP server
        javaMailSender.send(mimeMessage);
    }
}
