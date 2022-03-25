package com.assignment2.dtos;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class RestaurantDTO {//details shown in the restaurant list
    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String deliveryZones;
}
