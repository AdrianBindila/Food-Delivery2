package com.assignment2.dtos;

import com.assignment2.model.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {
    @NonNull
    private String customerFullName;
    @NonNull
    private LocalDate date;
    @NonNull
    private String deliveryAddress;
    @NonNull
    private OrderStatus status;
    @NonNull
    private int totalPrice;
    @NonNull
    private List<FoodDTO> items=new ArrayList<>();
}
