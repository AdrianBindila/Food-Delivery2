package com.assignment2.controller;

import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.model.Restaurant;
import com.assignment2.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getRestaurants(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "RestaurantController");
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return ResponseEntity.accepted().headers(headers).body(restaurants);
    }

    @PostMapping
    public void insertRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        restaurantService.insertRestaurant(restaurantDTO);
    }
}
