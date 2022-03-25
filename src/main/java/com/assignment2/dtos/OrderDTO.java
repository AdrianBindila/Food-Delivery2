package com.assignment2.dtos;

import com.assignment2.model.Food;
import com.assignment2.model.OrderStatus;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    @NonNull
    private OrderStatus status;
    @NonNull
    private LocalDate date;
    @NonNull
    private int totalPrice;
    @NonNull
    private List<Food> items;
}
