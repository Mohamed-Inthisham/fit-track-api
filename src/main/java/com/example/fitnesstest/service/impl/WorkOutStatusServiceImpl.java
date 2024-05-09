package com.example.fitnesstest.service.impl;

import com.example.fitnesstest.DTO.WorkoutStatusDTO;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.entity.WorkoutStatus;
import com.example.fitnesstest.repository.UserRepository;
import com.example.fitnesstest.repository.WorkoutStatusRepository;
import com.example.fitnesstest.response.WorkOutPlanResponse;
import com.example.fitnesstest.response.WorkOutResponse;
import com.example.fitnesstest.response.WorkoutStatusResponse;
import com.example.fitnesstest.service.WorkOutStatusService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WorkOutStatusServiceImpl implements WorkOutStatusService {

    private WorkoutStatusRepository workoutStatusRepository;
    private UserRepository userRepository;
    @Override
    public void createStatus(WorkoutStatusDTO workoutStatusDTO, Long uId) {

        User user = userRepository.findById(uId).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        WorkoutStatus workoutStatus = new WorkoutStatus();
        workoutStatus.setName(workoutStatusDTO.getName());
        workoutStatus.setReps(workoutStatusDTO.getReps());
        workoutStatus.setDescription(workoutStatusDTO.getDescription());
        workoutStatus.setDistance(workoutStatusDTO.getDistance());
        workoutStatus.setTimePerRep(workoutStatusDTO.getTimePerRep());
        workoutStatus.setTypeOfWorkout(workoutStatusDTO.getTypeOfWorkout());
        workoutStatus.setWorkoutLocation(workoutStatusDTO.getWorkoutLocation());
        workoutStatus.setUser(user);

    workoutStatusRepository.save(workoutStatus);

    }

    @Override
    public List<WorkoutStatusResponse> getAllStatus() {

        List<WorkoutStatus> workoutStatusList = workoutStatusRepository.findAll();
        List<WorkoutStatusResponse> workoutStatusResponseList = new ArrayList<>();

        for (WorkoutStatus workoutStatus:workoutStatusList
        ) {
            WorkoutStatusResponse workoutStatusResponse = WorkoutStatusResponse.builder()
                    .id(workoutStatus.getId())
                    .description(workoutStatus.getDescription())
                    .distance(workoutStatus.getDistance())
                    .name(workoutStatus.getName())
                    .timePerRep(workoutStatus.getTimePerRep())
                    .reps(workoutStatus.getReps())
                    .typeOfWorkout(workoutStatus.getTypeOfWorkout())
                    .workoutLocation(workoutStatus.getWorkoutLocation())
                    .user(workoutStatus.getUser())
                    .build();

            workoutStatusResponseList.add(workoutStatusResponse);
        }

        return workoutStatusResponseList;
    }

    @Override
    public void updateById(WorkoutStatusDTO workoutStatusDTO, Long id) {

        WorkoutStatus workoutStatus = workoutStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));

        workoutStatus.setName(workoutStatusDTO.getName());
        workoutStatus.setTypeOfWorkout(workoutStatusDTO.getTypeOfWorkout());
        workoutStatus.setTimePerRep(workoutStatusDTO.getTimePerRep());
        workoutStatus.setReps(workoutStatusDTO.getReps());
        workoutStatus.setReps(workoutStatusDTO.getReps());
        workoutStatus.setDistance(workoutStatusDTO.getDistance());
        workoutStatus.setDescription(workoutStatusDTO.getDescription());
        workoutStatus.setWorkoutLocation(workoutStatusDTO.getWorkoutLocation());

        workoutStatusRepository.save(workoutStatus);


    }

    @Override
    public WorkoutStatusResponse getByIdStatus(Long id) {
        WorkoutStatus workoutStatus = workoutStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("status not Found"));


        return WorkoutStatusResponse.builder()
                .name(workoutStatus.getName())
                .typeOfWorkout(workoutStatus.getTypeOfWorkout())
                .timePerRep(workoutStatus.getTimePerRep())
                .reps(workoutStatus.getReps())
                .distance(workoutStatus.getDistance())
                .description(workoutStatus.getDescription())
                .workoutLocation(workoutStatus.getWorkoutLocation())
                .build();
    }

    @Override
    public void deleteById(Long id) {
        WorkoutStatus workoutStatus = workoutStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("status not Found"));

        workoutStatusRepository.deleteById(workoutStatus.getId());
    }

}
