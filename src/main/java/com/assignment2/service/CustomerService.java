package com.assignment2.service;

import com.assignment2.dtos.UserDTO;
import com.assignment2.dtos.RegisterDTO;
import com.assignment2.dtos.RegisterMapper;
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
    public Customer getCustomer(UserDTO loginDTO){
        Encrypter encrypter=new Encrypter();
        return customerRepository.findByUsernameAndPassword(loginDTO.getUsername(), encrypter.encrypt(loginDTO.getPassword())).orElse(new Customer());
    }
    public void insertCustomer(RegisterDTO registerDTO){
        Customer customer=RegisterMapper.getInstance().convertFromDTO(registerDTO);
        Encrypter encrypter=new Encrypter();
        customer.setPassword(encrypter.encrypt(customer.getPassword()));
        customerRepository.save(customer);
    }
}