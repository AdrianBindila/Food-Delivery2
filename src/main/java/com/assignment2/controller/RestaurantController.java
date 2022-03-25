package com.assignment2.controller;

import com.assignment2.model.Restaurant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> restaurants(){
        return null;
    }

}
