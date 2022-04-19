package com.assignment2.dtos.mapper;


import com.assignment2.dtos.FoodDTO;
import com.assignment2.dtos.OrderDTO;
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
    }//Use a response factory for http responses

    public OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setCustomerFullName(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
        orderDTO.setDate(order.getDate());
        orderDTO.setDeliveryAddress(order.getDeliveryAddress());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setTotalPrice(order.getTotalPrice());
        order.getItems().forEach(item -> orderDTO.getItems().add(FoodMapper.getInstance().convertToDTO(item)));
        return orderDTO;
    }

    public Order convertFromDTO(OrderDTO orderDTO, Customer customer, Restaurant restaurant) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
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
