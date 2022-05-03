package com.assignment2.service;

import com.assignment2.dtos.UserDTO;
import com.assignment2.dtos.mapper.AdminMapper;
import com.assignment2.dtos.mapper.CustomerMapper;
import com.assignment2.dtos.mapper.UserMapper;
import com.assignment2.model.Admin;
import com.assignment2.model.Customer;
import com.assignment2.model.User;
import com.assignment2.repository.UserRepository;
import com.assignment2.security.UserPrincipal;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type User service retrieves the user from a database based on its credentials.
 */
@Service
@Log4j2
public class UserService implements UserDetailsService {
    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Gets user from the database.
     *
     * @param username the username
     * @param password the password
     * @return the user
     */
    public UserDTO getUser(String username, String password) {
        User user;
        user = userRepository.findByUsernameAndPassword(username, password).orElseThrow();
        if (user instanceof Admin admin) {
            log.info("User is admin");
            return AdminMapper.getInstance().convertToDTO(admin);
        } else if (user instanceof Customer customer) {
            log.info("User is customer");
            return CustomerMapper.getInstance().convertToDTO(customer);
        }
        return UserMapper.getInstance().convertToDTO(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return new UserPrincipal(user);
    }
}
