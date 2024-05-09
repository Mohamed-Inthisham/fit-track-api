package com.example.fitnesstest.repository;

import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutTempRepository extends JpaRepository<Workout, Long> {

    List<Workout> findWorkoutsByUser(User user);
}
