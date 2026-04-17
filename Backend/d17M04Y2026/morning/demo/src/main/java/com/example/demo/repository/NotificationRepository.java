package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByEmail(String email);

    List<Notification> findBySentAtAfter(LocalDateTime date);

    List<Notification> findBySuccessFalse();
}