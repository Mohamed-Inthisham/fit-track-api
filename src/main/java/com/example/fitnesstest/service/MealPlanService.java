package com.example.fitnesstest.service;

import com.example.fitnesstest.DTO.MealPlanDTO;
import com.example.fitnesstest.entity.MealPlan;
import com.example.fitnesstest.response.MealPlanResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MealPlanService {
    void saveMealPlan(MealPlanDTO mealPlanDTO, Long id);

//    List<MealPlanResponse> getAllMealPlans(Long id);


    void deleteMealPlan(Long id);

    ResponseEntity<List<MealPlan>> getByUserId(Long id);

    ResponseEntity<MealPlan> updatePlan(MealPlanDTO mealPlanDTO, Long id);

    MealPlanResponse getMealPlanById(Long id);
}
