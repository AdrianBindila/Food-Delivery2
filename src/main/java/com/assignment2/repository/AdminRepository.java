package com.assignment2.repository;

import com.assignment2.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    Optional<Admin> findByUsernameAndPassword(String username, String password);
    Optional<Admin> findByUsername(String u);
}
