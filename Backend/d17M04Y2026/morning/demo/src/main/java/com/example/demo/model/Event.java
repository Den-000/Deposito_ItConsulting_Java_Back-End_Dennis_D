package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private int maxSeats;
    private int bookedSeats;

    @ManyToOne
    private Location location;

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private List<TicketType> ticketTypes;
}