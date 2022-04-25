package com.assignment2.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * The type Email service is responsible for sending emails to restaurant administrators
 * whenever a new order is placed by a user at that restaurant.
 */
@Service
@Log4j2
public class EmailService {
    private static final String FROM_ADDRESS = "noreply@fooddelivery.com";
    /**
     * The Email sender.
     */
    @Autowired
    JavaMailSenderImpl emailSender;

    /**
     * Send an email to a specified address.
     * The email contains a subject and a text body with the details of the order.
     *
     * @param to      the address to send to
     * @param subject the subject
     * @param text    the text body
     */
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
