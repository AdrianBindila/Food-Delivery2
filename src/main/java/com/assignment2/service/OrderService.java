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

@Service
@Log4j2
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmailService emailService;

    public List<OrderDTO> getRestaurantOrders(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        List<Order> orders = orderRepository.findByRestaurant(restaurant);
        log.info("Get "+restaurant.getName()+" orders from DB");
        return orders.stream().map(order -> OrderMapper.getInstance().convertToDTO(order)).toList();
    }

    public List<OrderDTO> getCustomerOrders(String username) {
        Customer customer = customerRepository.findByUsername(username).orElse(new Customer());
        List<Order> orders = orderRepository.findByCustomer(customer);
        log.info("Get "+customer.getFirstName()+customer.getLastName()+" orders from DB");
        return orders.stream().map(order -> OrderMapper.getInstance().convertToDTO(order)).toList();
    }

    public void addOrder(OrderDTO orderDTO, String username, String restaurantName) {
        Customer customer = customerRepository.findByUsername(username).orElse(new Customer());
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        Order order = OrderMapper.getInstance().convertFromDTO(orderDTO, customer, restaurant);
        log.info("Insert order: "+order.getOrderId()+" in DB");
        orderRepository.save(order);
    }

    public List<OrderDTO> getPendingOrders(String username) {
        Customer customer = customerRepository.findByUsername(username).orElse(new Customer());
        List<Order> orders = orderRepository.findByStatusNotLikeAndStatusNotLikeAndCustomer(OrderStatus.DELIVERED, OrderStatus.DECLINED, customer);
        log.info("Get pending orders for "+username+" from DB");
        return orders.stream().map(order -> OrderMapper.getInstance().convertToDTO(order)).toList();
    }

    public void updateOrderStatus(OrderDTO orderDTO) {
        Order currentOrder = orderRepository.getById(orderDTO.getOrderId());
        currentOrder.setStatus(orderDTO.getStatus());
        log.info("Updated order "+currentOrder.getOrderId());
        orderRepository.save(currentOrder);
    }

    public void sendMail(OrderDTO orderDTO, String username, String restaurantName) {
        Customer customer = customerRepository.findByUsername(username).orElse(new Customer());
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElse(new Restaurant());
        Order order = OrderMapper.getInstance().convertFromDTO(orderDTO, customer, restaurant);
        log.info("Sent email with order no."+order.getOrderId()+" to restaurant: "+restaurant.getName());
        emailService.send(restaurant.getAdmin().getEmail(), customer.getFirstName(), printOrderForMail(order));
    }

    private String printOrderForMail(Order o) {
        StringBuilder s = new StringBuilder();
        s.append("Total: ");
        s.append(o.getTotalPrice());
        s.append("\n");
        s.append("Address: ");
        s.append(o.getDeliveryAddress());
        s.append("\n");
        List<String> itemList = o.getItems().stream().map(item -> item.getName() + ": " + item.getPrice() + "\n").toList();
        s.append(itemList);
        System.out.println(s);
        return s.toString();
    }
}
