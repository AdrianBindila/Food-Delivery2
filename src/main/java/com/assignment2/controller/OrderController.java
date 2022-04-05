package com.assignment2.controller;

import com.assignment2.dtos.OrderDTO;
import com.assignment2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public void addOrder(@Param("username") String username, @Param("restaurantName") String restaurantName, @RequestBody OrderDTO orderDTO) {
        orderService.addOrder(orderDTO, username, restaurantName);
    }
}
