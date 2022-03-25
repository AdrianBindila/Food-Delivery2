package com.assignment2.dtos;

import lombok.Getter;
import lombok.Setter;

public class RestaurantDTO {//details shown in the restaurant list
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String deliveryZones;
}
