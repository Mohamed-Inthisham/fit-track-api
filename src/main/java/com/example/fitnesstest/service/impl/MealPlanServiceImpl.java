package com.example.fitnesstest.service.impl;

import com.example.fitnesstest.DTO.MealPlanDTO;
import com.example.fitnesstest.entity.MealPlan;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.repository.MealPlanRepository;
import com.example.fitnesstest.repository.UserRepository;
import com.example.fitnesstest.response.MealPlanResponse;
import com.example.fitnesstest.service.MealPlanService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MealPlanServiceImpl implements MealPlanService {

    private MealPlanRepository mealPlanRepository;
    private UserRepository userRepository;

    @Override
    public void saveMealPlan(MealPlanDTO mealPlanDTO, Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));

        MealPlan mealPlan = new MealPlan();
        mealPlan.setIngredients(mealPlanDTO.getIngredients());
        mealPlan.setMealtype(mealPlanDTO.getMealtype());
        mealPlan.setMealtime(mealPlanDTO.getMealtime());
        mealPlan.setPhotoUrl(mealPlanDTO.getPhotoUrl());
        mealPlan.setCookingInstructions(mealPlanDTO.getCookingInstructions());
        mealPlan.setPortionSize(mealPlanDTO.getPortionSize());
        mealPlan.setUser(user);

        mealPlanRepository.save(mealPlan);
    }


//    @Override
//    public PostResponse getMealPlanById(Long id) {
//        return null;
//    }

    @Override
    public void deleteMealPlan(Long id) {

        MealPlan mealPlan = mealPlanRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Meal Plan Not Found!")
        );

        mealPlanRepository.deleteById(mealPlan.getId());

    }

    @Override
    public ResponseEntity<List<MealPlan>> getByUserId(Long id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User Not Found!")
        );

        List<MealPlan> mealPlanList = mealPlanRepository.findMealPlansByUser(user);

        return new ResponseEntity<>(mealPlanList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MealPlan> updatePlan(MealPlanDTO mealPlanDTO, Long id) {
        MealPlan mealPlan = mealPlanRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Meal Plan Not Found!")
        );


        mealPlan.setIngredients(mealPlanDTO.getIngredients());
        mealPlan.setMealtype(mealPlanDTO.getMealtype());
        mealPlan.setMealtime(mealPlanDTO.getMealtime());
        mealPlan.setPhotoUrl(mealPlanDTO.getPhotoUrl());
        mealPlan.setCookingInstructions(mealPlanDTO.getCookingInstructions());
        mealPlan.setPortionSize(mealPlanDTO.getPortionSize());

        mealPlanRepository.save(mealPlan);

        return new ResponseEntity<>(mealPlan, HttpStatus.CREATED);
    }

    @Override
    public MealPlanResponse getMealPlanById(Long id) {
        MealPlan mealPlan = mealPlanRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Meal Plan Not Found!")
        );

        MealPlanResponse mealPlanResponse = new MealPlanResponse();
        mealPlanResponse.setId(mealPlan.getId());
        mealPlanResponse.setMealtype(mealPlan.getMealtype());
        mealPlanResponse.setMealtime(mealPlan.getMealtime());
        mealPlanResponse.setCookingInstructions(mealPlan.getCookingInstructions());
        mealPlanResponse.setPortionSize(mealPlan.getPortionSize());
        mealPlanResponse.setPhotoUrl(mealPlan.getPhotoUrl());
        mealPlanResponse.setIngredients(mealPlan.getIngredients());

        return mealPlanResponse;

    }


}
