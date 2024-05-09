package com.example.fitnesstest.DTO;

import com.example.fitnesstest.entity.User;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class MealPlanDTO {

    private Long id;
    private String mealtime;
    private String mealtype;
    private String ingredients;
    private String cookingInstructions;
    private String portionSize;
    private String photoUrl;
}
