package com.assignment2.service;

import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.dtos.RestaurantMapper;
import com.assignment2.model.Admin;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin findAdmin(String username, String password){
        return adminRepository.findByUsernameAndPassword(username, password).orElse(new Admin());//TODO set an error for when not found
    }

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
