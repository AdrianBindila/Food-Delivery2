package com.assignment2.dtos;

import com.assignment2.model.Customer;

public class LoginMapper {
    private static final LoginMapper instance = new LoginMapper();

    private LoginMapper() {
    }

    public static LoginMapper getInstance() {
        return instance;
    }

    public LoginDTO convertToDTO(Customer customer) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(customer.getUsername());
        loginDTO.setPassword(customer.getPassword());
        return loginDTO;
    }
}
