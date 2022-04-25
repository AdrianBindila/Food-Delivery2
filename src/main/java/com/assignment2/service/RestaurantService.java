package com.assignment2.service;

import com.assignment2.dtos.FoodDTO;
import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.dtos.mapper.FoodMapper;
import com.assignment2.dtos.mapper.RestaurantMapper;
import com.assignment2.model.Food;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.RestaurantRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> getRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        log.info("Get restaurants from DB");
        return restaurantList.stream().map(restaurant -> RestaurantMapper.getInstance().convertToDTO(restaurant)).toList();
    }

    public void insertFood(FoodDTO foodDTO, String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        Food food = FoodMapper.getInstance().convertFromDTO(foodDTO);
        food.setRestaurant(restaurant);
        restaurant.getMenu().add(food);
        log.info("Added " + food.getName() + " for restaurant " + restaurant.getName());
        restaurantRepository.save(restaurant);
    }
}
