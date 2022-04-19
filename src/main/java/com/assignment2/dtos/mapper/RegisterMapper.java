package com.assignment2.dtos.mapper;

import com.assignment2.dtos.RegisterDTO;
import com.assignment2.model.Customer;

public class RegisterMapper {
    private static final RegisterMapper instance = new RegisterMapper();

    private RegisterMapper() {
    }

    public static RegisterMapper getInstance() {
        return instance;
    }
    public Customer convertFromDTO(RegisterDTO registerDTO){
        Customer customer=new Customer();
        customer.setFirstName(registerDTO.getFirstName());
        customer.setLastName(registerDTO.getLastName());
        customer.setAddress(registerDTO.getAddress());
        customer.setEmail(registerDTO.getEmail());
        customer.setPhoneNumber(registerDTO.getPhone());
        customer.setUsername(registerDTO.getUsername());
        customer.setPassword(registerDTO.getPassword());
        return customer;
    }
}
