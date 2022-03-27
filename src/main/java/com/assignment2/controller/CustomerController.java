package com.assignment2.controller;

import com.assignment2.dtos.CustomerDTO;
import com.assignment2.dtos.RegisterDTO;
import com.assignment2.model.Customer;
import com.assignment2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping
    public ResponseEntity<Customer> getCustomer(@Param("id") Long customerId){
        Customer customer=customerService.getCustomer(customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CustomerController");
        return ResponseEntity.accepted().headers(headers).body(customer);
    }

    @PostMapping
    public void addCustomer(@RequestBody RegisterDTO customer) {
        System.out.println(customer);

    }
}
