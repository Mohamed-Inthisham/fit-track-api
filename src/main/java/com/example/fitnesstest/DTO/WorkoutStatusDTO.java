package com.example.fitnesstest.DTO;

import com.example.fitnesstest.entity.User;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class WorkoutStatusDTO {
    private User user;
    private String name;
    private int reps;
    private String timePerRep;
    private String distance;
    private String typeOfWorkout;
    private String description;
    private String workoutLocation;
}
