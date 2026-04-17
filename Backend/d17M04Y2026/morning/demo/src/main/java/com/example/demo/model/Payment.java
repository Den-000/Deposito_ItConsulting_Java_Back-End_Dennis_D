package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments") // nome tabella

@Data // Lombok: genera getter, setter, toString, ecc.
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id @GeneratedValue
    private Long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private String method; // CARD, PAYPAL

    private LocalDateTime paymentDate;

    @OneToOne
    private Ticket ticket;
}