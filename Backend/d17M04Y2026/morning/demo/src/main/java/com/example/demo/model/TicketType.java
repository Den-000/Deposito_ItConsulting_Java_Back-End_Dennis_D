package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketType {

    @Id @GeneratedValue
    private Long id;

    private String name; // VIP, STANDARD
    private double price;
    private int totalSeats;
    private int availableSeats;

    @ManyToOne
    private Event event;
}