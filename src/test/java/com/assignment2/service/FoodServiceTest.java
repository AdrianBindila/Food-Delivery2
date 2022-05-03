package com.assignment2.service;

import com.assignment2.dtos.FoodDTO;
import com.assignment2.model.Food;
import com.assignment2.model.FoodCategory;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.FoodRepository;
import com.assignment2.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FoodServiceTest {
    @Mock
    FoodRepository foodRepository;
    @Mock
    RestaurantRepository restaurantRepository;
    @InjectMocks
    FoodService foodService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getMenuFound() {
        Restaurant restaurant=new Restaurant();
        restaurant.setName("test");
        Food food=new Food();
        food.setName("strudel");
        food.setCategory(FoodCategory.BREAKFAST);
        restaurant.setMenu(List.of(food));

        when(restaurantRepository.findByName("test")).thenReturn(Optional.of(restaurant));
        when(foodRepository.findByRestaurant(restaurant)).thenReturn(restaurant.getMenu());

        List<FoodDTO> menu=foodService.getMenu("test");
        assertEquals("strudel",menu.get(0).getName());
    }
}