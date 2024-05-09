package com.example.fitnesstest.DTO;

import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.entity.Workout;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalTime;

@Data
public class WorkOutPlanDTO {

    private User user;
    private String name;
    private int reps;
    private String timePerRep;
    private String distance;
    private String typeOfWorkout;
    private String description;
    private String workoutLocation;
}
