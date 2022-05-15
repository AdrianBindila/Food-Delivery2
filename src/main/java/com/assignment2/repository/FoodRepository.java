package com.assignment2.repository;

import com.assignment2.model.Food;
import com.assignment2.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByRestaurant(Restaurant restaurant);
}
