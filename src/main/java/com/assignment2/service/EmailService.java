package com.assignment2.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmailService {
    private static final String FROM_ADDRESS = "noreply@fooddelivery.com";
    @Autowired
    JavaMailSenderImpl emailSender;

    public void send(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(FROM_ADDRESS);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
            log.error("Mail not sent:\n" + to + "\n" + subject + "\n" + text);
        }
    }
}
