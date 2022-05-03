package com.assignment2.service;

import com.assignment2.repository.CustomerRepository;
import com.assignment2.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class EmailServiceTest {
    @Mock
    RestaurantRepository restaurantRepository;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    JavaMailSenderImpl javaMailSender;
    @InjectMocks
    EmailService emailService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void sendMail() {

    }
}