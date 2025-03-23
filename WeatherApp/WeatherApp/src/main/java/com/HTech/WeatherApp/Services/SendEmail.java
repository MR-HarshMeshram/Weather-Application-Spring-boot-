package com.HTech.WeatherApp.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {
    private static final Logger log = LoggerFactory.getLogger(SendEmail.class);
    @Autowired
    JavaMailSender javaMailSender;
    public  void sendEmail(String to , String subject,String body){
        try {
            SimpleMailMessage email=new SimpleMailMessage();
            email.setTo(to);
            email.setSubject(subject);
            email.setText(body);
            javaMailSender.send(email);
        }catch (Exception e){
            log.error(" email not sending ",e);
        }
    }
}
