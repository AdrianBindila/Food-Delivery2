package com.assignment2.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admins")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Admin {
    @Id
    @GeneratedValue
    public Long adminId;

    @Column(nullable = false)
    public String username;


    @Column(nullable = false)
    public String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    public Restaurant restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Admin admin = (Admin) o;
        return adminId != null && Objects.equals(adminId, admin.adminId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
