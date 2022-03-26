package com.assignment2.dtos;

import com.assignment2.model.FoodCategory;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
public class FoodDTO {
    @NonNull
    private String name;
    private String description;
    @NonNull
    private int price;
    @NonNull
    private FoodCategory category;
}
