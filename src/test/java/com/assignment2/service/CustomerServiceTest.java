package com.assignment2.service;

import com.assignment2.dtos.RegisterDTO;
import com.assignment2.dtos.UserDTO;
import com.assignment2.model.Customer;
import com.assignment2.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;
    private Customer sampleCustomer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleCustomer = new Customer();
        sampleCustomer.setFirstName("John");
        sampleCustomer.setUsername("asdf");
        sampleCustomer.setPassword("123");
        when(customerService.customerRepository.findByUsernameAndPassword(sampleCustomer.getUsername(), new Encrypter().encrypt(sampleCustomer.getPassword())))
                .thenReturn(Optional.of(sampleCustomer));
    }

    @Test
    void getCustomerFound() {
        assertEquals("John",
                customerService.getCustomer(new UserDTO("asdf", "123")).getFirstName());
    }

    @Test
    void testGetCustomerNotFound() {
        assertThrows(NoSuchElementException.class,
                ()->customerService.getCustomer(new UserDTO("non","existent")));
    }

    @Test
    void insertCustomer() {
        RegisterDTO registerDTO=new RegisterDTO();
        registerDTO.setUsername("asdf");
        registerDTO.setPassword("123");
        customerService.insertCustomer(registerDTO);
        assertEquals("John",customerService.getCustomer(new UserDTO("asdf","123")).getFirstName());
    }
}