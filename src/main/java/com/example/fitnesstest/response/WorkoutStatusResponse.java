package com.example.fitnesstest.response;

import com.example.fitnesstest.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkoutStatusResponse {

    private Long id;
    private User user;
    private String name;
    private int reps;
    private String timePerRep;
    private String distance;
    private String typeOfWorkout;
    private String description;
    private String workoutLocation;
}
