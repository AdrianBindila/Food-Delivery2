package com.assignment2.dtos;


import com.assignment2.model.Customer;
import com.assignment2.model.Food;
import com.assignment2.model.Order;
import com.assignment2.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    private static final OrderMapper instance = new OrderMapper();

    private OrderMapper() {
    }

    public static OrderMapper getInstance() {
        return instance;
    }

    public OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDate(order.getDate());
        order.getItems().forEach(item -> orderDTO.getItems().add(FoodMapper.getInstance().convertToDTO(item)));//IDK if this does what it should
        orderDTO.setStatus(order.getStatus());
        orderDTO.setTotalPrice(order.getTotalPrice());
        return orderDTO;
    }

    public Order convertFromDTO(OrderDTO orderDTO, Customer customer, Restaurant restaurant) {

        Order order = new Order();

        order.setDate(orderDTO.getDate());
        List<Food> foodList = new ArrayList<>();
        for (FoodDTO item :
                orderDTO.getItems()) {
            foodList.add
                    (restaurant
                            .getMenu()
                            .stream()
                            .filter
                                    (menuItem -> menuItem
                                            .getName()
                                            .equals(item.getName()))
                            .findFirst()
                            .orElse(new Food()));
        }
        order.setItems(foodList);
        order.setDeliveryAddress(customer.getAddress());
        order.setStatus(orderDTO.getStatus());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setCustomer(customer);//get it from the current customer
        order.setRestaurant(restaurant);//get it from the selected restaurant
        return order;
    }
}
//orderDTO
//        .getItems()
//        .stream()
//        .filter(item ->
//        {//for each food item from the orderDTO find the corresponding menu item from the restaurant menu, based on name
//        return restaurant.getMenu().stream().anyMatch(menuItem -> menuItem.getName().equals(item.getName()));
//        })
//        .collect(Collectors.toList()))