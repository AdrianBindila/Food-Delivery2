package com.assignment2.repository;

import com.assignment2.model.Customer;
import com.assignment2.model.Order;
import com.assignment2.model.OrderStatus;
import com.assignment2.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(Customer c);

    List<Order> findByRestaurant(Restaurant r);

    List<Order> findByCustomerAndStatus(Customer c, OrderStatus orderStatus);
}
