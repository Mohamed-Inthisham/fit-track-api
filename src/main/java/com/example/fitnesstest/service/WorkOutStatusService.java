package com.example.fitnesstest.service;

import com.example.fitnesstest.DTO.WorkoutStatusDTO;
import com.example.fitnesstest.response.WorkoutStatusResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkOutStatusService {
    void createStatus(WorkoutStatusDTO workoutStatusDTO, Long uId);

    List<WorkoutStatusResponse> getAllStatus();

    void updateById(WorkoutStatusDTO workoutStatusDTO, Long id);

    WorkoutStatusResponse getByIdStatus(Long id);

    void deleteById(Long id);

//    List<WorkoutStatusResponse> getStatus(Long uId);

//    List<WorkOutPlanResponse> getAll();
}
