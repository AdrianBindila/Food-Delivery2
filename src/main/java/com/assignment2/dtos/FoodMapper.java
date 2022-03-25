package com.assignment2.dtos;

import com.assignment2.model.Food;
import com.assignment2.model.Restaurant;

import java.util.ArrayList;

public class FoodMapper {
    public Food convertFromDTO(FoodDTO foodDTO) {
        Food food = new Food();
        food.setCategory(foodDTO.getCategory());
        food.setDescription(foodDTO.getDescription());
        food.setPrice(foodDTO.getPrice());
        food.setName(foodDTO.getName());
        food.setOrders(new ArrayList<>());
        food.setRestaurant(new Restaurant());
        return food;
    }

    public FoodDTO convertToDTO(Food food) {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setCategory(food.getCategory());
        foodDTO.setDescription(food.getDescription());
        foodDTO.setName(food.getName());
        foodDTO.setPrice(food.getPrice());
        return foodDTO;
    }
}
