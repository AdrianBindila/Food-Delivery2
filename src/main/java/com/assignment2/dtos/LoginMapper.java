package com.assignment2.dtos;

import com.assignment2.model.Customer;

public class LoginMapper {
    public LoginDTO convertToDTO(Customer customer){
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUsername(customer.getUsername());
        loginDTO.setPassword(customer.getPassword());

        return loginDTO;
    }
}
