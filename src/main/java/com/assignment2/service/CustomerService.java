package com.assignment2.service;

import com.assignment2.model.Customer;
import com.assignment2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public Customer getCustomer(Long customerId){
        return customerRepository.findById(customerId).orElse(new Customer());
    }
}