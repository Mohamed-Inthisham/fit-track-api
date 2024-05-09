package com.example.fitnesstest.repository;

import com.example.fitnesstest.entity.MealPlan;
import com.example.fitnesstest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {

    List<MealPlan> findMealPlansByUser(User user);
}
