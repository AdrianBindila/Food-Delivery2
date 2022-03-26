package com.assignment2.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
public class LoginDTO {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
