package com.example.fitnesstest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Long workoutId;
    @ManyToOne
    @JsonIgnoreProperties("user")
    private User user;
    @Column(name = "name")
    private String name;
    @Column(name = "reps")
    private int reps;
    private String timePerRep;
    private String distance;

    private String typeOfWorkout;
    private String description;
    private String workoutLocation;
}
