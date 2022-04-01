package com.assignment2.controller;

import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.model.Admin;
import com.assignment2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping
    public ResponseEntity<Admin> getAdmin(@Param("username") String username, @Param("password") String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "AdminController");
        Admin admin = adminService.findAdmin(username, password);
        return ResponseEntity.accepted().headers(headers).body(admin);
    }

    @PostMapping("/addRestaurant")//add restaurant to existing admin
    public ResponseEntity<RestaurantDTO> addRestaurant(@Param("username") String username, @RequestBody RestaurantDTO restaurantDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "AdminController");

        adminService.addRestaurant(username, restaurantDTO);
        return ResponseEntity.accepted().headers(headers).body(restaurantDTO);
    }


}
