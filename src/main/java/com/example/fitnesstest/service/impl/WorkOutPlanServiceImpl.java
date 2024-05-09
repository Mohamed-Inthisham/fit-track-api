package com.example.fitnesstest.service.impl;

import com.example.fitnesstest.DTO.WorkOutPlanDTO;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.entity.Workout;
import com.example.fitnesstest.repository.UserRepository;
import com.example.fitnesstest.repository.WorkoutPlanRepository;
import com.example.fitnesstest.repository.WorkoutTempRepository;
import com.example.fitnesstest.response.WorkOutResponse;
import com.example.fitnesstest.service.WorkoutPlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WorkOutPlanServiceImpl implements WorkoutPlanService {

    private WorkoutPlanRepository workoutPlanRepository;
    private UserRepository userRepository;
    private WorkoutTempRepository workoutTempRepository;



    @Override
    public ResponseEntity<String> saveTemplate(WorkOutPlanDTO workOutPlanDTO, Long uId) {
        User user = userRepository.findById(uId).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        Workout workout = new Workout();
        workout.setUser(user);
        workout.setName(workOutPlanDTO.getName());
        workout.setReps(workOutPlanDTO.getReps());
        workout.setTimePerRep(workOutPlanDTO.getTimePerRep());
        workout.setDistance(workOutPlanDTO.getDistance());
        workout.setDescription(workOutPlanDTO.getDescription());
        workout.setTypeOfWorkout(workOutPlanDTO.getTypeOfWorkout());
        workout.setWorkoutLocation(workOutPlanDTO.getWorkoutLocation());

        workoutTempRepository.save(workout);

        return new ResponseEntity<>("Workout Template Created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<WorkOutResponse>> getAllTemplatesUserId(Long uId) {
        User user = userRepository.findById(uId).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        List<Workout> workoutList = workoutTempRepository.findWorkoutsByUser(user);
        List<WorkOutResponse> workOutResponseList = new ArrayList<>();

        for (Workout workout:workoutList
             ) {
            WorkOutResponse workOutResponse = new WorkOutResponse();
            workOutResponse.setDescription(workout.getDescription());
            workOutResponse.setDistance(workout.getDistance());
            workOutResponse.setTimePerRep(workout.getTimePerRep());
            workOutResponse.setTypeOfWorkout(workout.getTypeOfWorkout());
            workOutResponse.setName(workout.getName());
            workOutResponse.setReps(workout.getReps());
            workOutResponse.setWorkoutLocation(workout.getWorkoutLocation());

            workOutResponseList.add(workOutResponse);
        }
        return new ResponseEntity<>(workOutResponseList, HttpStatus.OK);
    }


}


