package com.assignment2.service;

import com.assignment2.dtos.RegisterDTO;
import com.assignment2.dtos.UserDTO;
import com.assignment2.dtos.mapper.RegisterMapper;
import com.assignment2.model.Customer;
import com.assignment2.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomer(UserDTO loginDTO){
        Encrypter encrypter=new Encrypter();
        log.info("Found user"+loginDTO.getUsername());
        return customerRepository.findByUsernameAndPassword(loginDTO.getUsername(), encrypter.encrypt(loginDTO.getPassword())).orElse(new Customer());
    }
    public void insertCustomer(RegisterDTO registerDTO){
        Customer customer=RegisterMapper.getInstance().convertFromDTO(registerDTO);
        Encrypter encrypter=new Encrypter();
        customer.setPassword(encrypter.encrypt(customer.getPassword()));
        customerRepository.save(customer);
        log.info("Add customer "+customer.getFirstName());
    }
}