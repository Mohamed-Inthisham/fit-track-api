package com.example.fitnesstest.entity;

import com.example.fitnesstest.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "MealPlans")
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private String mealtime;
    private String mealtype;
    private String ingredients;
    private String cookingInstructions;
    private String portionSize;
    private String photoUrl;
}
