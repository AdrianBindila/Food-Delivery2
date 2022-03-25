package com.assignment2.dtos;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class RegisterDTO {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String address;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String confirmPassword;
}
