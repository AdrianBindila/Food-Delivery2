package com.assignment2.controller;

import com.assignment2.dtos.RegisterDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @PostMapping("/AddCustomer")
    public ResponseEntity<RegisterDTO> addCustomer(@RequestBody RegisterDTO customer) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CustomerController");
        return ResponseEntity.accepted().headers(headers).body(customer);
    }
}
