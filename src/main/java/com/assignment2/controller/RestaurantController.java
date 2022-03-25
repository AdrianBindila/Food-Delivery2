package com.assignment2.controller;

import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getRestaurants(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "RestaurantController");
        List<RestaurantDTO> restaurants = null;
        return ResponseEntity.accepted().headers(headers).body(restaurants);
    }

}
