package com.assignment2.service;

import com.assignment2.dtos.RegisterDTO;
import com.assignment2.dtos.UserDTO;
import com.assignment2.dtos.mapper.RegisterMapper;
import com.assignment2.model.Customer;
import com.assignment2.repository.CustomerRepository;
import com.assignment2.repository.RoleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The Customer service manages the customers of the application.
 * It contains methods for getting and inserting customers.
 */
@Service
@Log4j2
public class CustomerService {
    /**
     * The Customer repository.
     */
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RoleRepository roleRepository;

    /**
     * Get customer from login credentials.
     *
     * @param loginDTO the login dto
     * @return the customer
     */
    public Customer getCustomer(UserDTO loginDTO) {
        log.info("Found user" + loginDTO.getUsername());
        return customerRepository.findByUsername(loginDTO.getUsername()).orElseThrow();
    }

    /**
     * Insert a new customer based on the register credentials.
     *
     * @param registerDTO the register dto
     */
    public void insertCustomer(RegisterDTO registerDTO) {
        Customer customer = RegisterMapper.getInstance().convertFromDTO(registerDTO);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRole(roleRepository.findByName("CUSTOMER").orElseThrow());
        customerRepository.save(customer);
        log.info("Add customer " + customer.getFirstName());
    }
}