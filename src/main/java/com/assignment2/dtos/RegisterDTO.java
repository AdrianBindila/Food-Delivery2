package com.assignment2.dtos;

import lombok.Getter;

public class RegisterDTO {
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String email;
    @Getter
    private String address;
    @Getter
    private String phoneNumber;
    @Getter
    private String username;
    @Getter
    private String password;
    private String confirmPassword;
}
