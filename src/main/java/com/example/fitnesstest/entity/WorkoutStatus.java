package com.example.fitnesstest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "WorkoutStatus")
public class WorkoutStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private String name;
    private int reps;
    private String timePerRep;
    private String distance;
    private String typeOfWorkout;
    private String description;
    private String workoutLocation;


}