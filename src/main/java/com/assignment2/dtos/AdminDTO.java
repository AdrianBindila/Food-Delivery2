package com.assignment2.dtos;

import lombok.Data;

@Data
public class AdminDTO extends UserDTO{
    private RestaurantDTO restaurant;
}
