package com.assignment2.repository;

import com.assignment2.model.Food;
import com.assignment2.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByRestaurant(Restaurant restaurant);
}
