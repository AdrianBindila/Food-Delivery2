package com.assignment2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue
    private Long foodId;
    @Getter
    @Setter
    @Column(nullable = false)
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    @Column(nullable = false)
    private int price;
    @Getter
    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodCategory category;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
    @Getter
    @Setter
    @ManyToMany(mappedBy = "items")
    private List<Order> orders;
}
