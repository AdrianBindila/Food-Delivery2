package com.assignment2.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private int totalPrice;

    @JoinColumn(nullable = false)
    @OneToOne
    private Customer customer;

    @JoinColumn
    @OneToOne
    private Restaurant restaurant;

    @Column(nullable = false)
    @OneToMany
    private Set<Food> items;
}
