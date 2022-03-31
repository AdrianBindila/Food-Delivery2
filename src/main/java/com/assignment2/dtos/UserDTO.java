package com.assignment2.dtos;

import lombok.*;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
