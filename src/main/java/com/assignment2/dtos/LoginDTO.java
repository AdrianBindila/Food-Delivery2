package com.assignment2.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Data
public class LoginDTO {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
