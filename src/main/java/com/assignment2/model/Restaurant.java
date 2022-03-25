package com.assignment2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue
    private Long restaurantId;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private String address;

    @Getter
    @Setter
    @Column(nullable = false)
    private String deliveryZones;

    @Getter
    @Setter
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Food> menu;

    @Getter
    @Setter
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Order> orders;

    @Getter
    @Setter
    @OneToOne(mappedBy = "restaurant")
    private Admin admin;
}
