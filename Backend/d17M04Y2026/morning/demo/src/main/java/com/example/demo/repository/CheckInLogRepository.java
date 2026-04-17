package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CheckInLog;

public interface CheckInLogRepository extends JpaRepository<CheckInLog, Long> {

    List<CheckInLog> findByQrCode(String qrCode);
}