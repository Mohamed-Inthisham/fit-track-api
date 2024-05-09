package com.example.fitnesstest.controller;

import com.example.fitnesstest.DTO.WorkoutStatusDTO;
import com.example.fitnesstest.entity.WorkoutStatus;
import com.example.fitnesstest.repository.WorkoutStatusRepository;
import com.example.fitnesstest.response.WorkOutPlanResponse;
import com.example.fitnesstest.response.WorkoutStatusResponse;
import com.example.fitnesstest.service.WorkOutStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class WorkoutStatusController {

    private WorkOutStatusService workOutStatusService;
    private WorkoutStatusRepository workoutStatusRepository;

    @PostMapping("/status/{uId}")
    public ResponseEntity<Object> createStatus(@RequestBody WorkoutStatusDTO workoutStatusDTO, @PathVariable Long uId){

        workOutStatusService.createStatus(workoutStatusDTO, uId);
        return new ResponseEntity<>("Status Created", HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public List<WorkoutStatusResponse> getAllStatus(){
        return workOutStatusService.getAllStatus();
    }

    @GetMapping("/status/{id}")
    public WorkoutStatusResponse getByIdStatus(@PathVariable Long id){
        return workOutStatusService.getByIdStatus(id);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateById(@RequestBody WorkoutStatusDTO workoutStatusDTO, @PathVariable Long id){
        workOutStatusService.updateById(workoutStatusDTO, id);

        return new ResponseEntity<>("Status Updated!", HttpStatus.OK);
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        workOutStatusService.deleteById(id);
        return new ResponseEntity<>("Workout Status deleted!", HttpStatus.OK);
    }



}
