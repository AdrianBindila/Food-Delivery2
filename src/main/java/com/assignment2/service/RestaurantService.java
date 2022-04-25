package com.assignment2.service;

import com.assignment2.dtos.FoodDTO;
import com.assignment2.dtos.mapper.FoodMapper;
import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.dtos.mapper.RestaurantMapper;
import com.assignment2.model.Food;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    public List<RestaurantDTO> getRestaurants(){
        List<Restaurant> restaurantList=restaurantRepository.findAll();
        return restaurantList.stream().map(restaurant -> RestaurantMapper.getInstance().convertToDTO(restaurant)).toList();
    }
    public void insertFood(FoodDTO foodDTO, String restaurantName){
        Restaurant restaurant=restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        Food food=FoodMapper.getInstance().convertFromDTO(foodDTO);
        food.setRestaurant(restaurant);
        restaurant.getMenu().add(food);
        restaurantRepository.save(restaurant);
    }
}
