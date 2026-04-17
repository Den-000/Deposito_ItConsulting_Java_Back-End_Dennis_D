package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ticket;

public interface CheckInLogRepository extends JpaRepository<CheckInLog, Long> {

    List<CheckInLog> findByTicket(Ticket ticket);
}