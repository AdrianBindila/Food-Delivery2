package com.assignment2.dtos;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class CustomerDTO {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
}
