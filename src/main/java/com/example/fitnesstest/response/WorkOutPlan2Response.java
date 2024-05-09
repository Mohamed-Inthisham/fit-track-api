package com.example.fitnesstest.response;

import com.example.fitnesstest.entity.User;
import lombok.Data;

@Data
public class WorkOutPlan2Response {
    private Long id;
    private User user;
    private String workoutType;
    private String duration;
    private String excerciesName;
    private String repitition;
    private String Description;
}
