package com.assignment2.dtos;

import lombok.Data;

@Data
public class CustomerDTO extends UserDTO{

    private String firstName;

    private String lastName;

    private String email;
}
