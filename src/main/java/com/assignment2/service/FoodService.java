package com.assignment2.service;

import com.assignment2.dtos.FoodDTO;
import com.assignment2.dtos.mapper.FoodMapper;
import com.assignment2.model.Food;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.FoodRepository;
import com.assignment2.repository.RestaurantRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class FoodService {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<FoodDTO> getMenu(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        List<Food> foodList = foodRepository.findByRestaurant(restaurant);
        log.info("Get menu for restaurant: " + restaurant.getName());
        return foodList.stream().map(food -> FoodMapper.getInstance().convertToDTO(food)).toList();
    }
}
