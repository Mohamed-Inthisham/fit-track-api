package com.example.fitnesstest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "WorkoutPlans")
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long planId;
    @ManyToOne
    private User user;
    private String name;
    @Column(name = "reps")
    private int reps;
    private String setsCount;
    private String typeOfWorkout;
    private String description;
    private String workoutLocation;


}