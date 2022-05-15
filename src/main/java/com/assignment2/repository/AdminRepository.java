package com.assignment2.repository;

import com.assignment2.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Optional<Admin> findByUsernameAndPassword(String username, String password);
    Optional<Admin> findByUsername(String u);
}
