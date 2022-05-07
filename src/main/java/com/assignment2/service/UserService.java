package com.assignment2.service;

import com.assignment2.dtos.UserDTO;
import com.assignment2.dtos.mapper.AdminMapper;
import com.assignment2.dtos.mapper.CustomerMapper;
import com.assignment2.dtos.mapper.UserMapper;
import com.assignment2.model.Admin;
import com.assignment2.model.Customer;
import com.assignment2.model.User;
import com.assignment2.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User service retrieves the user from a database based on its credentials.
 */
@Service
@Log4j2
public class UserService {
    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Gets user from the database.
     *
     * @param username the username
     *
     * @return the user
     */
    public UserDTO getUser(String username) {
        User user;
        user = userRepository.findByUsername(username).orElseThrow();
        if (user instanceof Admin admin) {
            log.info("User is admin");
            return AdminMapper.getInstance().convertToDTO(admin);
        } else if (user instanceof Customer customer) {
            log.info("User is customer");
            return CustomerMapper.getInstance().convertToDTO(customer);
        }
        return UserMapper.getInstance().convertToDTO(user);
    }
}
