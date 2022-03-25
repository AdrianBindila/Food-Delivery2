package com.assignment2.service;

import com.assignment2.model.Admin;
import com.assignment2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin getAdmin(String username, String password){
        return adminRepository.findByUsernameAndPassword(username, password).orElse(new Admin());
    }
}
