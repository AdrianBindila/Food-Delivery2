package com.assignment2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "restaurants")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    private Long restaurantId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String deliveryZones;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private List<Food> menu;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private List<Order> orders;

    @OneToOne(mappedBy = "restaurant", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Admin admin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Restaurant that = (Restaurant) o;
        return restaurantId != null && Objects.equals(restaurantId, that.restaurantId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
