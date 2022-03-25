package com.assignment2.dtos;

import com.assignment2.model.FoodCategory;
import lombok.Getter;
import lombok.Setter;

public class FoodDTO {//Menu of a selected restaurant
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private int price;
    @Getter
    @Setter
    private FoodCategory category;
}
