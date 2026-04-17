package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets") // nome tabella

@Data // Lombok: genera getter, setter, toString, ecc.
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id @GeneratedValue
    private Long id;

    private String qrCode;

    private boolean valid;
    private boolean checkedIn;

    private LocalDateTime purchaseDate;

    @ManyToOne
    private MyUser user;

    @ManyToOne
    private Event event;

    @ManyToOne
    private TicketType ticketType;

    @OneToOne(mappedBy = "ticket")
    private Payment payment;
}