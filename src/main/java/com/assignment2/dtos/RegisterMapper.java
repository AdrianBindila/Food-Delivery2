package com.assignment2.dtos;

import com.assignment2.model.Customer;

public class RegisterMapper {
    public Customer convertFromDTO(RegisterDTO registerDTO){
        Customer customer=new Customer();
        customer.setFirstName(registerDTO.getFirstName());
        customer.setLastName(registerDTO.getLastName());
        customer.setAddress(registerDTO.getAddress());
        customer.setEmail(registerDTO.getEmail());
        customer.setPhoneNumber(registerDTO.getPhoneNumber());
        customer.setUsername(registerDTO.getUsername());
        customer.setPassword(registerDTO.getPassword());
    }
}
