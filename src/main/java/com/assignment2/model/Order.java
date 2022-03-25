package com.assignment2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Getter
    @Setter
    @Column(nullable = false)
    private String deliveryAddress;

    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDate date;

    @Getter
    @Setter
    @Column(nullable = false)
    private int totalPrice;

    @Getter
    @Setter
    @Column(nullable = false)
    @ManyToMany
    @JoinTable(
            name = "order_food",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Food> items;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
