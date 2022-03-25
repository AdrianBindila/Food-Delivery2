package com.assignment2.service;

import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    List<RestaurantDTO> getRestaurants() {

        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        return restaurantDTOS;
    }
}
