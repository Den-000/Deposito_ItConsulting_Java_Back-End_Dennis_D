package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "check_in_log")
@NoArgsConstructor
@AllArgsConstructor
public class CheckInLog {

    @Id
    @GeneratedValue
    private Long id;

    private String qrCode;

    private LocalDateTime checkInTime;
}