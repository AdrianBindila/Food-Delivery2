package com.assignment2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    @Getter
    @Setter
    @Column(nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column(nullable = false)
    private String lastName;

    @Getter
    @Setter
    @Column(nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(nullable = false)
    private String address;

    @Getter
    @Setter
    @Column(nullable = false)
    private String phoneNumber;

    @Getter
    @Setter
    @Column(nullable = false)
    private String username;

    @Getter
    @Setter
    @Column(nullable = false)
    private String password;

    @Transient
    private Order currentOrder;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderHistory;
}
