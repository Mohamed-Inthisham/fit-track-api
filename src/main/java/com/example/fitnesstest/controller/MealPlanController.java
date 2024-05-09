package com.example.fitnesstest.controller;

import com.example.fitnesstest.DTO.MealPlanDTO;
import com.example.fitnesstest.DTO.PostDTO;
import com.example.fitnesstest.entity.MealPlan;
import com.example.fitnesstest.repository.MealPlanRepository;
import com.example.fitnesstest.response.CommonResponse;
import com.example.fitnesstest.response.MealPlanResponse;
import com.example.fitnesstest.response.PostResponse;
import com.example.fitnesstest.service.MealPlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class MealPlanController {

    private MealPlanService mealPlanService;
    private MealPlanRepository mealPlanRepository;

    @PostMapping("/meals/{user_id}")
    public ResponseEntity<CommonResponse> saveMealPlan(@RequestBody MealPlanDTO mealPlanDTO, @PathVariable ("user_id") Long id)  {

        mealPlanService.saveMealPlan(mealPlanDTO, id);
        return ResponseEntity.ok(new CommonResponse("Meal Plan Created"));
    }

    @GetMapping("/meals")
    public ResponseEntity<List<MealPlan>> getAllMealPlan(){
        List<MealPlan> mealPlanList = mealPlanRepository.findAll();
        return new ResponseEntity<>(mealPlanList, HttpStatus.OK);
    }


    @GetMapping("/meals/{user_id}")
    public ResponseEntity<List<MealPlan>> getMealPlanUserId(@PathVariable ("user_id") Long id){
        return mealPlanService.getByUserId(id);
    }

    @GetMapping("/meals/meal/{meal_id}")
    public MealPlanResponse getMealPlanById(@PathVariable ("meal_id") Long id){
        return mealPlanService.getMealPlanById(id);
    }



    @PutMapping("/meals/{meal_id}")
    public ResponseEntity<MealPlan> updateMealPlan(@RequestBody MealPlanDTO mealPlanDTO,@PathVariable("meal_id") Long id){
        return mealPlanService.updatePlan(mealPlanDTO,id);
    }

    @DeleteMapping("/meals/{meal_id}")
    public ResponseEntity<?> deleteMealPlan(@PathVariable ("meal_id") Long id){
        mealPlanService.deleteMealPlan(id);

        return ResponseEntity.ok("Meal Plan Deleted!");
    }
}
