package com.assignment2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final String FROM_ADDRESS="noreply@fooddelivery.com";
    @Autowired
    JavaMailSenderImpl emailSender;
    public void send(String to, String subject, String text){
        try{
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom(FROM_ADDRESS);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        }catch (MailException e){
            e.printStackTrace();
        }
    }
}
