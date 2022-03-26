package com.assignment2.dtos;


import com.assignment2.model.Customer;
import com.assignment2.model.Order;
import com.assignment2.model.Restaurant;

public class OrderMapper {
    private static OrderMapper instance = new OrderMapper();

    private OrderMapper() {
    }

    public static OrderMapper getInstance() {
        return instance;
    }
    public OrderDTO convertToDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDate(order.getDate());
        orderDTO.setItems(order.getItems());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setTotalPrice(order.getTotalPrice());
        return orderDTO;
    }
    public Order convertFromDTO(OrderDTO orderDTO){
        Order order=new Order();
        order.setDate(orderDTO.getDate());
        order.setItems(orderDTO.getItems());
        order.setStatus(orderDTO.getStatus());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setCustomer(new Customer());//get it from the current customer
        order.setRestaurant(new Restaurant());//get it from the selected restaurant
        return order;
    }
}
