package com.assignment2.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Transient
    private Order currentOrder;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Order> orderHistory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return customerId != null && Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
