package com.assignment2.dtos;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class CustomerDTO extends UserDTO{

    private String firstName;

    private String lastName;

    private String email;
}
