package com.assignment2.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "foods")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Food {

    @Id
    @GeneratedValue
    private Long foodId;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodCategory category;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "items", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Food food = (Food) o;
        return foodId != null && Objects.equals(foodId, food.foodId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
