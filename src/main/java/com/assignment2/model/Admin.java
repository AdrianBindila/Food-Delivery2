package com.assignment2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "admins")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends User{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    public Restaurant restaurant;
}
