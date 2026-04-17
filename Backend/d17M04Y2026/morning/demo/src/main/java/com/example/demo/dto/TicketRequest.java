package com.example.demo.dto;

import lombok.Data;

@Data
public class TicketRequest {
    private Long eventId;
    private Long ticketTypeId;
    private String email;
}