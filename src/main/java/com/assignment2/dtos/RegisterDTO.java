package com.assignment2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String phone;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String confirmedPassword;
}
