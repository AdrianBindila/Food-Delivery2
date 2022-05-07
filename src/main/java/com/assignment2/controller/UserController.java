package com.assignment2.controller;

import com.assignment2.dtos.UserDTO;
import com.assignment2.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Log4j2
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<UserDTO> login(@Param("username") String username, @Param("password") String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "UserController");
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);
        UserDTO userDTO = userService.getUser(username);
        if(passwordEncoder.matches(password,userDTO.getPassword())){
            log.info("Logged in user: " + username);
            return ResponseEntity.accepted().headers(headers).body(userDTO);
        }else {
            log.info("invalid passowrd");
            return null;
        }
    }
}
