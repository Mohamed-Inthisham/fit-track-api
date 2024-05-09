package com.example.fitnesstest.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "workout_plan")
public class WorkOutPlan2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String workoutType;
    private String duration;
    private String excerciesName;
    private String repitition;
    private String Description;
}
