package com.assignment2.controller;

import com.assignment2.dtos.UserDTO;
import com.assignment2.model.User;
import com.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<UserDTO> login(@Param("username") String username, @Param("password") String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "UserController");
        UserDTO userDTO = userService.getUser(username, password);
        return ResponseEntity.accepted().headers(headers).body(userDTO);
    }
}
