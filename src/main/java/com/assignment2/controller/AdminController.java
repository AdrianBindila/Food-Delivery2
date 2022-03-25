package com.assignment2.controller;

import com.assignment2.model.Admin;
import com.assignment2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/GetAdmin/{username}/{password}")
    public ResponseEntity<Admin> getAdmin(@PathVariable String username, @PathVariable String password) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("Responded","AdminController");
        Admin admin=adminService.getAdmin(username, password);
        return ResponseEntity.accepted().headers(headers).body(admin);
    }


}
