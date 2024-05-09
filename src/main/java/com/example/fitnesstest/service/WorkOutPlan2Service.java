package com.example.fitnesstest.service;

import com.example.fitnesstest.DTO.WorkOutPlan2DTO;
import com.example.fitnesstest.entity.WorkOutPlan2;
import com.example.fitnesstest.response.WorkOutPlan2Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkOutPlan2Service {
    ResponseEntity<String> createWorkoutPlan(WorkOutPlan2DTO workOutPlan2DTO, Long id);

    List<WorkOutPlan2> getAllWorkout();

    void updateWorkoutPlan(WorkOutPlan2DTO workOutPlan2DTO, Long id);

    WorkOutPlan2Response getById(Long id);

    void deleteById(Long id);
}
