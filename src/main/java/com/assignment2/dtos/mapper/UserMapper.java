package com.assignment2.dtos.mapper;

import com.assignment2.dtos.UserDTO;
import com.assignment2.model.User;

public class UserMapper {
    private static final UserMapper instance = new UserMapper();

    private UserMapper() {
    }

    public static UserMapper getInstance() {
        return instance;
    }

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
