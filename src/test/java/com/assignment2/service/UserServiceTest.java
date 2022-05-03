package com.assignment2.service;


import com.assignment2.dtos.UserDTO;
import com.assignment2.model.User;
import com.assignment2.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getUserFound() {
        User user = new User();
        user.setUsername("Hello");
        user.setPassword("World");
        when(userService.userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()))
                .thenReturn(Optional.of(user));
        UserDTO newUser = userService.getUser(user.getUsername(), user.getPassword());
        assertEquals("Hello", newUser.getUsername());
    }

    @Test
    public void getUserNotFound() {
        assertThrows(NoSuchElementException.class,()-> userService.getUser("asada","aiadhihd"));
    }
}