package com.assignment2.service;

import com.assignment2.model.User;
import com.assignment2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUser(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password).orElse(new User());
    }
}
