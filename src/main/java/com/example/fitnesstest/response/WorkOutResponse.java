package com.example.fitnesstest.response;

import lombok.Data;

@Data
public class WorkOutResponse {
    private String name;
    private int reps;
    private String timePerRep;
    private String distance;
    private String typeOfWorkout;
    private String description;
    private String workoutLocation;
}
