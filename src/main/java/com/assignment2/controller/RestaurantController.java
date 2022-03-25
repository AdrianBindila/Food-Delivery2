package com.assignment2.controller;

import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.model.Restaurant;
import com.assignment2.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantDTO>> restaurants(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "RestaurantController");
        List<RestaurantDTO> restaurants=restaurantService.getRestaurantDTO;
        return ResponseEntity.accepted().headers(headers).body(restaurants);
    }

}
