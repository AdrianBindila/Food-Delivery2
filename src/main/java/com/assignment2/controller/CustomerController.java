package com.assignment2.controller;

import com.assignment2.dtos.LoginDTO;
import com.assignment2.dtos.RegisterDTO;
import com.assignment2.model.Customer;
import com.assignment2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<Customer> getCustomer(LoginDTO loginDTO) {
        Customer customer = customerService.getCustomer(loginDTO);
        System.out.println(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CustomerController");
        return ResponseEntity.accepted().headers(headers).body(customer);
    }

    @PostMapping
    public void insertCustomer(@RequestBody RegisterDTO customer) {
        System.out.println(customer);
        customerService.insertCustomer(customer);
    }
}
