package com.assignment2.service;

import com.assignment2.dtos.OrderDTO;
import com.assignment2.dtos.mapper.OrderMapper;
import com.assignment2.model.Customer;
import com.assignment2.model.Order;
import com.assignment2.model.OrderStatus;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.CustomerRepository;
import com.assignment2.repository.OrderRepository;
import com.assignment2.repository.RestaurantRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Order service manages the orders of either customers or restaurants.
 */
@Service
@Log4j2
public class OrderService {
    /**
     * The Order repository.
     */
    @Autowired
    OrderRepository orderRepository;
    /**
     * The Restaurant repository.
     */
    @Autowired
    RestaurantRepository restaurantRepository;
    /**
     * The Customer repository.
     */
    @Autowired
    CustomerRepository customerRepository;

    /**
     * Gets restaurant orders.
     *
     * @param restaurantName the restaurant name
     * @return the restaurant orders
     */
    public List<OrderDTO> getRestaurantOrders(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        List<Order> orders = orderRepository.findByRestaurant(restaurant);
        log.info("Get "+restaurant.getName()+" orders from DB");
        return orders.stream().map(order -> OrderMapper.getInstance().convertToDTO(order)).toList();
    }

    /**
     * Gets customer orders.
     *
     * @param username the username of the customer
     * @return the customer orders
     */
    public List<OrderDTO> getCustomerOrders(String username) {
        Customer customer = customerRepository.findByUsername(username).orElse(new Customer());
        List<Order> orders = orderRepository.findByCustomer(customer);
        log.info("Get "+customer.getFirstName()+customer.getLastName()+" orders from DB");
        return orders.stream().map(order -> OrderMapper.getInstance().convertToDTO(order)).toList();
    }

    /**
     * Add order to a restaurant.
     *
     * @param orderDTO       the order dto
     * @param username       the username
     * @param restaurantName the restaurant name
     */
    public void addOrder(OrderDTO orderDTO, String username, String restaurantName) {
        Customer customer = customerRepository.findByUsername(username).orElse(new Customer());
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        Order order = OrderMapper.getInstance().convertFromDTO(orderDTO, customer, restaurant);
        log.info("Insert order: "+order.getOrderId()+" in DB");
        orderRepository.save(order);
    }

    /**
     * Gets pending orders for a client.
     *
     * @param username the username of the client
     * @return the pending orders
     */
    public List<OrderDTO> getPendingOrders(String username) {
        Customer customer = customerRepository.findByUsername(username).orElse(new Customer());
        List<Order> orders = orderRepository.findByStatusNotLikeAndStatusNotLikeAndCustomer(OrderStatus.DELIVERED, OrderStatus.DECLINED, customer);
        log.info("Get pending orders for "+username+" from DB");
        return orders.stream().map(order -> OrderMapper.getInstance().convertToDTO(order)).toList();
    }

    /**
     * Update order status.
     *
     * @param orderDTO the order dto
     */
    public void updateOrderStatus(OrderDTO orderDTO) {
        Order currentOrder = orderRepository.getById(orderDTO.getOrderId());
        currentOrder.setStatus(orderDTO.getStatus());
        log.info("Updated order "+currentOrder.getOrderId());
        orderRepository.save(currentOrder);
    }
}
