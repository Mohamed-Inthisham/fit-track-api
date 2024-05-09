package com.example.fitnesstest.response;

import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.entity.Workout;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
@Builder
public class WorkOutPlanResponse {

    private Long planId;
    private Long userId;
    private List<Workout> workoutList;
    private String planDetails;
    private LocalTime createdAt;
    private LocalTime updatedAt;
}
