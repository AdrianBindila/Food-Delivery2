package com.assignment2.controller;

import com.assignment2.dtos.OrderDTO;
import com.assignment2.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public void addOrder(@Param("username") String username, @Param("restaurantName") String restaurantName, @RequestBody OrderDTO orderDTO) {
        orderService.addOrder(orderDTO, username, restaurantName);
        orderService.sendMail(orderDTO, username, restaurantName);
        log.info("POST order\n" + username + "\n" + restaurantName + "\n" + orderDTO.getOrderId());
    }

    @GetMapping("/restaurant")
    public ResponseEntity<List<OrderDTO>> getRestaurantOrders(@Param("restaurantName") String restaurantName) {
        List<OrderDTO> orders = orderService.getRestaurantOrders(restaurantName);
        log.info("GET restaurant orders " + restaurantName);
        return ResponseEntity.accepted().body(orders);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<OrderDTO>> getCustomerOrders(@Param("username") String username) {
        List<OrderDTO> orders = orderService.getCustomerOrders(username);
        log.info("GET customer orders " + username);
        return ResponseEntity.accepted().body(orders);
    }

    @PostMapping("/restaurant/update")
    public void updateOrder(@RequestBody OrderDTO orderDTO) {
        orderService.updateOrderStatus(orderDTO);
        log.info("Updated order " + orderDTO.getOrderId());
    }
}
