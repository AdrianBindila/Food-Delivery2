package com.assignment2.service;

import com.assignment2.dtos.OrderDTO;
import com.assignment2.dtos.OrderMapper;
import com.assignment2.model.Customer;
import com.assignment2.model.Order;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.CustomerRepository;
import com.assignment2.repository.OrderRepository;
import com.assignment2.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    CustomerRepository customerRepository;

    public List<OrderDTO> getRestaurantOrders(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        List<Order> orders = orderRepository.findByRestaurant(restaurant);
        return orders.stream().map(order -> OrderMapper.getInstance().convertToDTO(order)).toList();
    }

    public List<OrderDTO> getCustomerOrders(String username) {
        Customer customer = customerRepository.findByUsername(username).orElse(new Customer());
        List<Order> orders = orderRepository.findByCustomer(customer);
        return orders.stream().map(order -> OrderMapper.getInstance().convertToDTO(order)).toList();
    }

    public void addOrder(OrderDTO orderDTO, String customerUsername, String restaurantName) {
        Customer customer = customerRepository.findByUsername(customerUsername).orElse(new Customer());
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        Order order = OrderMapper.getInstance().convertFromDTO(orderDTO, customer, restaurant);
        orderRepository.save(order);
    }
}
