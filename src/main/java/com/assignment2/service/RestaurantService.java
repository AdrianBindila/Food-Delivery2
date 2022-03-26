package com.assignment2.service;

import com.assignment2.dtos.FoodMapper;
import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.dtos.RestaurantMapper;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }
    public void insertRestaurant(RestaurantDTO restaurantDTO){

    }

    public void insertRestaurant(Restaurant restaurant) {

    }
}
