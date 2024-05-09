package com.example.fitnesstest.service.impl;

import com.example.fitnesstest.DTO.WorkOutPlan2DTO;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.entity.WorkOutPlan2;
import com.example.fitnesstest.repository.UserRepository;
import com.example.fitnesstest.repository.WorkOutPlan2Repository;
import com.example.fitnesstest.response.WorkOutPlan2Response;
import com.example.fitnesstest.service.WorkOutPlan2Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkOutPlan2ServiceImpl implements WorkOutPlan2Service {

    private UserRepository userRepository;
    private WorkOutPlan2Repository workOutPlan2Repository;
    @Override
    public ResponseEntity<String> createWorkoutPlan(WorkOutPlan2DTO workOutPlan2DTO, Long id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        WorkOutPlan2 workOutPlan2 = new WorkOutPlan2();
        workOutPlan2.setDescription(workOutPlan2DTO.getDescription());
        workOutPlan2.setDuration(workOutPlan2DTO.getDuration());
        workOutPlan2.setWorkoutType(workOutPlan2DTO.getWorkoutType());
        workOutPlan2.setExcerciesName(workOutPlan2DTO.getExcerciesName());
        workOutPlan2.setRepitition(workOutPlan2DTO.getRepitition());
        workOutPlan2.setUser(user);

        workOutPlan2Repository.save(workOutPlan2);

        return new ResponseEntity<>("Workout plan Created!", HttpStatus.CREATED);

    }

    @Override
    public List<WorkOutPlan2> getAllWorkout() {

        return workOutPlan2Repository.findAll();
    }

    @Override
    public void updateWorkoutPlan(WorkOutPlan2DTO workOutPlan2DTO, Long id) {

        WorkOutPlan2 workOutPlan2 = workOutPlan2Repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Workout Plan Not Found!"));

        workOutPlan2.setExcerciesName(workOutPlan2DTO.getExcerciesName());
        workOutPlan2.setRepitition(workOutPlan2DTO.getRepitition());
        workOutPlan2.setDuration(workOutPlan2DTO.getDuration());
        workOutPlan2.setDescription(workOutPlan2DTO.getDescription());
        workOutPlan2.setExcerciesName(workOutPlan2DTO.getExcerciesName());

        workOutPlan2Repository.save(workOutPlan2);
    }

    @Override
    public WorkOutPlan2Response getById(Long id) {
        WorkOutPlan2 workOutPlan2DTO = workOutPlan2Repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Workout Plan Not Found!"));

        WorkOutPlan2Response workOutPlan2 = new WorkOutPlan2Response();

        workOutPlan2.setId(workOutPlan2DTO.getId());
        workOutPlan2.setExcerciesName(workOutPlan2DTO.getExcerciesName());
        workOutPlan2.setRepitition(workOutPlan2DTO.getRepitition());
        workOutPlan2.setDuration(workOutPlan2DTO.getDuration());
        workOutPlan2.setDescription(workOutPlan2DTO.getDescription());
        workOutPlan2.setExcerciesName(workOutPlan2DTO.getExcerciesName());
        workOutPlan2.setUser(workOutPlan2DTO.getUser());

        return workOutPlan2;
    }

    @Override
    public void deleteById(Long id) {
        WorkOutPlan2 workOutPlan2DTO = workOutPlan2Repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Workout Plan Not Found!"));
        workOutPlan2Repository.deleteById(workOutPlan2DTO.getId());
    }
}
