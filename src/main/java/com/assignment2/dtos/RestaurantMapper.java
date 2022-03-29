package com.assignment2.dtos;

import com.assignment2.model.Restaurant;

public class RestaurantMapper {
    private static final RestaurantMapper instance = new RestaurantMapper();

    private RestaurantMapper() {
    }

    public static RestaurantMapper getInstance() {
        return instance;
    }

    public Restaurant convertFromDTO(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setDeliveryZones(restaurantDTO.getDeliveryZones());
        restaurant.setName(restaurantDTO.getName());
        return restaurant;
    }

    public RestaurantDTO convertToDTO(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setDeliveryZones(restaurant.getDeliveryZones());
        return restaurantDTO;
    }
}
