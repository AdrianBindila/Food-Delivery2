package com.assignment2.dtos.mapper;

import com.assignment2.dtos.CustomerDTO;
import com.assignment2.model.Customer;

public class CustomerMapper {
    private static final CustomerMapper instance=new CustomerMapper();
    private CustomerMapper(){

    }
    public static CustomerMapper getInstance() {
        return instance;
    }
    public CustomerDTO convertToDTO(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }
}
