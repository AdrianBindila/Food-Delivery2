package com.assignment2.dtos;

import com.assignment2.model.Food;
import com.assignment2.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {
    @Getter
    @Setter
    private OrderStatus status;
    @Getter
    @Setter
    private LocalDate date;
    @Getter
    @Setter
    private int totalPrice;
    @Getter
    @Setter
    private List<Food> items;
}
