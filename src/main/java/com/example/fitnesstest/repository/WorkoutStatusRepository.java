package com.example.fitnesstest.repository;

import com.example.fitnesstest.entity.WorkoutStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutStatusRepository extends JpaRepository<WorkoutStatus, Long> {
}
