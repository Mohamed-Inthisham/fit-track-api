package com.example.fitnesstest.response;

import com.example.fitnesstest.entity.User;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@Data
public class MealPlanResponse {

    private Long id;
    private String mealtime;
    private String mealtype;
    private String ingredients;
    private String cookingInstructions;
    private String portionSize;
    private String photoUrl;
}
