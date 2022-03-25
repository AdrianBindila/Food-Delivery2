package com.assignment2.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String deliveryZones;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Food> menu;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne(mappedBy = "restaurant")
    private Admin admin;
}
