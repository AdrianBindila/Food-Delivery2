package com.assignment2.service;

import com.assignment2.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class EncrypterTest {
    private final Encrypter encrypter=new Encrypter();
    @Test
    void encrypt() {
        assertEquals("202CB962AC59075B964B07152D234B70",encrypter.encrypt("123"));
    }
}