package com.example.fitnesstest.controller;

import com.example.fitnesstest.DTO.WorkOutPlanDTO;
import com.example.fitnesstest.response.CommonResponse;
import com.example.fitnesstest.response.WorkOutResponse;
import com.example.fitnesstest.service.WorkoutPlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class WorkoutPlanController {

    private WorkoutPlanService workoutPlanService;

    @PostMapping("/workoutPlans/template/{user_id}")
    public ResponseEntity<String> setWorkoutTemplate(@RequestBody WorkOutPlanDTO workOutPlanDTO, @PathVariable("user_id") Long uId) {
        return workoutPlanService.saveTemplate(workOutPlanDTO, uId);
    }

    @GetMapping("/workoutPlans/template/{user_id}")
    public ResponseEntity<List<WorkOutResponse>> getAllTemplatesUserId(@PathVariable("user_id") Long uId) {
        return workoutPlanService.getAllTemplatesUserId(uId);
    }
}
