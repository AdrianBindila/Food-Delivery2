package com.assignment2.controller;

import com.assignment2.dtos.FoodDTO;
import com.assignment2.dtos.OrderDTO;
import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.service.FoodService;
import com.assignment2.service.OrderService;
import com.assignment2.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    FoodService foodService;
    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getRestaurants(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "RestaurantController");
        List<RestaurantDTO> restaurants = restaurantService.getRestaurants();
        return ResponseEntity.accepted().headers(headers).body(restaurants);
    }

    @GetMapping("/food")
    public ResponseEntity<List<FoodDTO>> getFood(@Param("restaurantName") String restaurantName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "RestaurantController");
        List<FoodDTO> menuDTO=foodService.getMenu(restaurantName);
        System.out.println(menuDTO);
        return ResponseEntity.accepted().headers(headers).body(menuDTO);
    }

    @PostMapping("/food")
    public void insertFood(@Param("restaurantName") String restaurantName, @RequestBody FoodDTO foodDTO){
        restaurantService.insertFood(foodDTO, restaurantName);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDTO>> getOrders(@Param("restaurantName") String restaurantName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "RestaurantController");
        List<OrderDTO> orderDTOS=orderService.getRestaurantOrders(restaurantName);
        return ResponseEntity.accepted().headers(headers).body(orderDTOS);
    }
}
