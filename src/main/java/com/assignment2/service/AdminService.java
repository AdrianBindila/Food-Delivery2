package com.assignment2.service;

import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.dtos.mapper.RestaurantMapper;
import com.assignment2.model.Admin;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The type Admin service is responsible for handling the administrator of a restaurant.
 * This class contains methods for finding an admin adding a restaurant to an existing admin.
 */
@Service
public class AdminService {
    /**
     * The Admin repository.
     */
    @Autowired
    AdminRepository adminRepository;

    /**
     * Find the administrator for the provided credentials.
     *
     * @param username the admin username
     * @param password the admin password
     * @return the admin
     */
    public Admin findAdmin(String username, String password){
        return adminRepository.findByUsernameAndPassword(username, password).orElse(new Admin());
    }

    /**
     * Add restaurant of an admin.
     *
     * @param adminUsername the admin username
     * @param restaurantDTO the restaurant dto
     */
    public void addRestaurant(String adminUsername, RestaurantDTO restaurantDTO) {
        Restaurant restaurant=RestaurantMapper.getInstance().convertFromDTO(restaurantDTO);

        adminRepository.findByUsername(adminUsername).ifPresentOrElse(
                admin -> {
                    admin.setRestaurant(restaurant);
                    adminRepository.save(admin);
                },
                () -> System.out.println("Admin not found!")
        );
    }
}
