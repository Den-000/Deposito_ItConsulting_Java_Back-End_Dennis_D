package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Event;
import com.example.demo.model.EventStatus;

public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findByName(String name);

    List<Event> findByDateAfter(LocalDateTime date);

    List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);

    List<Event> findByStatus(EventStatus status);
}