package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notifications") // nome tabella

@Data // Lombok: genera getter, setter, toString, ecc.
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id @GeneratedValue
    private Long id;

    private String email;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private LocalDateTime sentAt;

    private boolean success;
}