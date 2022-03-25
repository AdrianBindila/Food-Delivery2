package com.assignment2.controller;

import com.assignment2.model.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public ResponseEntity<Admin> getAdmin(@RequestParam String username,@RequestParam String password){
        return null;
    }
}
