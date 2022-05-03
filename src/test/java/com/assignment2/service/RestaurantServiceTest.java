package com.assignment2.service;

import com.assignment2.dtos.FoodDTO;
import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.model.FoodCategory;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class RestaurantServiceTest {
    @Mock
    RestaurantRepository restaurantRepository;
    @InjectMocks
    RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant1=new Restaurant();
        restaurant1.setName("Hello");
        restaurant1.setAddress("a");
        restaurant1.setDeliveryZones("a");
        Restaurant restaurant2=new Restaurant();
        restaurant2.setName("World");
        restaurant2.setAddress("ad");
        restaurant2.setDeliveryZones("aa");
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        when(restaurantService.restaurantRepository.findAll()).thenReturn(restaurants);
        when(restaurantService.restaurantRepository.findByName("Hello")).thenReturn(Optional.of(restaurant1));
    }

    @Test
    void getRestaurants() {
        List<RestaurantDTO> restaurantDTOS=restaurantService.getRestaurants();
        assertEquals("World",restaurantDTOS.get(1).getName());
    }

    @Test
    void insertFood() {
        FoodDTO foodDTO=new FoodDTO();
        foodDTO.setName("Pancakes");
        foodDTO.setCategory(FoodCategory.BREAKFAST);
        restaurantService.insertFood(foodDTO,"Hello");
        Restaurant restaurant=restaurantService.restaurantRepository.findByName("Hello").orElseThrow();
        assertEquals("Pancakes",restaurant.getMenu().get(0).getName());
    }
}