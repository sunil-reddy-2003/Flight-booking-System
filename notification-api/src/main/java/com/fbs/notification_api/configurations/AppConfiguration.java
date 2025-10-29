package com.fbs.notification_api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;

import java.util.HashMap;
import java.util.Properties;

@Configuration
public class AppConfiguration {

    @Bean
    public HashMap<Integer,Integer> generateHashMap(){
        return new HashMap<>();
    }

    @Bean
    public JavaMailSender generateJavaMailSender(){
        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();

        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("sunilreddy@gmail.com");
        javaMailSender.setPassword("sunil");
        Properties properties=javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");

        return  javaMailSender;
    }

    @Bean
    public TemplateEngine getThymeleafBean(){
        return new TemplateEngine();
    }
}
