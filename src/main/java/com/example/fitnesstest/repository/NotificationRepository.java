package com.example.fitnesstest.repository;

import com.example.fitnesstest.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
