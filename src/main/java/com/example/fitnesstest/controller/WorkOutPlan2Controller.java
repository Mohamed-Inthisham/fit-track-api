package com.example.fitnesstest.controller;

import com.example.fitnesstest.DTO.WorkOutPlan2DTO;
import com.example.fitnesstest.entity.WorkOutPlan2;
import com.example.fitnesstest.response.WorkOutPlan2Response;
import com.example.fitnesstest.service.WorkOutPlan2Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WorkOutPlan2Controller {

    private WorkOutPlan2Service workOutPlan2Service;

    @PostMapping("/workoutplan/{user_id}")
    public ResponseEntity<String> createWorkoutPlan(@RequestBody WorkOutPlan2DTO workOutPlan2DTO, @PathVariable ("user_id")Long id){
        return workOutPlan2Service.createWorkoutPlan(workOutPlan2DTO, id);
    }

    @GetMapping("/workoutplan")
    public List<WorkOutPlan2> getAllWorkout(){
        return workOutPlan2Service.getAllWorkout();
    }

    @GetMapping("/workoutplan/{id}")
    public WorkOutPlan2Response getById(@PathVariable Long id){
        return workOutPlan2Service.getById(id);
    }

    @PutMapping("/workoutplan/{id}")
    public ResponseEntity<String> updateWorkout(@RequestBody WorkOutPlan2DTO workOutPlan2DTO, @PathVariable Long id){
        workOutPlan2Service.updateWorkoutPlan(workOutPlan2DTO,id);

        return new ResponseEntity<>("Workout Plan updated!", HttpStatus.CREATED);
    }

    @DeleteMapping("/workoutplan/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        workOutPlan2Service.deleteById(id);
        return new ResponseEntity<>("Workout Plan deleted!", HttpStatus.OK);
    }

}
