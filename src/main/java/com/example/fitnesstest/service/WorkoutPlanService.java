package com.example.fitnesstest.service;

import com.example.fitnesstest.DTO.WorkOutPlanDTO;
import com.example.fitnesstest.response.WorkOutResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkoutPlanService {


    ResponseEntity<String> saveTemplate(WorkOutPlanDTO workOutPlanDTO, Long uId);

    ResponseEntity<List<WorkOutResponse>> getAllTemplatesUserId(Long uId);


//    List<WorkOutPlanResponse> getAllPlans();
//
//    WorkOutPlanResponse getPostById(Long id);
//
//    void deletePlan(Long id);
}
