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
        // This bean creates and returns an empty HashMap that can be used anywhere in the project
        return new HashMap<>();
    }

    @Bean
    public JavaMailSender generateJavaMailSender(){
        // This bean creates and configures the JavaMailSender object used to send emails from the backend
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        // Set the Gmail SMTP server because we are using a Gmail account to send emails
        javaMailSender.setHost("smtp.gmail.com");

        // Port 587 is used for sending emails using TLS (secure email sending)
        javaMailSender.setPort(587);

        // The email address that will be used by the backend to send emails to users
        javaMailSender.setUsername("sunilreddymandadi@gmail.com");

        // This is the Gmail app password (not the actual Gmail login password)
        javaMailSender.setPassword("xcws kwub xtne nptc");

        Properties props = javaMailSender.getJavaMailProperties();

        // Enable authentication so Spring Boot can log into Gmail using the app password
        props.put("mail.smtp.auth", "true");

        // Enable TLS encryption to send emails securely
        props.put("mail.smtp.starttls.enable", "true");

        return javaMailSender;
    }

    @Bean
    public TemplateEngine getThymeleafBean(){
        // This bean creates a TemplateEngine object used by Thymeleaf to process email templates
        return new TemplateEngine();
    }
}
