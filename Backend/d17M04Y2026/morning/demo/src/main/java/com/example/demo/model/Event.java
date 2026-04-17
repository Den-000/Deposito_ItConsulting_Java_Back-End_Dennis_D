package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "events") // nome tabella

@Data // Lombok: genera getter, setter, toString, ecc.
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String description;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "event")
    private List<TicketType> ticketTypes;
}