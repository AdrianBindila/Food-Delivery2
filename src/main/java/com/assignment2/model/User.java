package com.assignment2.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User{
    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false, unique = true)//TODO: remove this field from customer and its DTO
    public String email;

    @Column(nullable = false, unique = true)
    public String username;

    @Column(nullable = false)
    public String password;
}
