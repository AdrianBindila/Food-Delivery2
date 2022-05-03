package com.assignment2.service;

import com.assignment2.dtos.OrderDTO;
import com.assignment2.model.*;
import com.assignment2.repository.CustomerRepository;
import com.assignment2.repository.OrderRepository;
import com.assignment2.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;
    @Mock
    RestaurantRepository restaurantRepository;
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    OrderService orderService;
    Restaurant restaurant;
    Customer customer;
    Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        restaurant = new Restaurant();
        restaurant.setName("Hello");
        restaurant.setAddress("a");
        restaurant.setDeliveryZones("a");

        customer = new Customer();
        customer.setFirstName("John");
        customer.setUsername("asdf");
        customer.setPassword("123");

        order = new Order();
        order.setOrderId(5L);
        order.setCustomer(customer);
        order.setDate(LocalDate.EPOCH);
        order.setDeliveryAddress("hh");
        order.setStatus(OrderStatus.PENDING);

        Food food = new Food();
        food.setName("strudel");
        food.setCategory(FoodCategory.BREAKFAST);
        order.setItems(List.of(food));

        when(orderService.customerRepository.findByUsername("asdf")).thenReturn(Optional.ofNullable(customer));
        when(orderService.restaurantRepository.findByName("Hello")).thenReturn(Optional.of(restaurant));
        when(orderService.orderRepository.findByRestaurant(restaurant)).thenReturn(List.of(order));
        when(orderService.orderRepository.findByCustomer(customer)).thenReturn(List.of(order));
        when(orderService.orderRepository.findByStatusNotLikeAndStatusNotLikeAndCustomer(OrderStatus.DELIVERED,OrderStatus.DECLINED,customer))
                .thenReturn(List.of(order));
        when(orderRepository.getById(order.getOrderId())).thenReturn(order);
    }

    @Test
    void getRestaurantOrders() {
        assertEquals(5L, orderService.getRestaurantOrders("Hello").get(0).getOrderId());
    }

    @Test
    void getCustomerOrders() {
        assertEquals(5L, orderService.getCustomerOrders("asdf").get(0).getOrderId());
    }

    @Test
    void addOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(5L);
        orderDTO.setDate(LocalDate.EPOCH);
        orderDTO.setDeliveryAddress("hh");
        orderDTO.setStatus(OrderStatus.DELIVERED);
        orderService.addOrder(orderDTO, "asdf", "Hello");
        assertEquals(5L, orderService.getCustomerOrders("asdf").get(0).getOrderId());
    }

    @Test
    void getPendingOrders() {
        assertEquals(5L,orderService.getPendingOrders("asdf").get(0).getOrderId());
    }

    @Test
    void updateOrderStatus() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(5L);
        orderDTO.setDate(LocalDate.EPOCH);
        orderDTO.setDeliveryAddress("hh");
        orderDTO.setStatus(OrderStatus.IN_DELIVERY);
        orderService.updateOrderStatus(orderDTO);
        assertEquals(OrderStatus.IN_DELIVERY,orderService.getCustomerOrders("asdf").get(0).getStatus());
    }
}