package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponse {
    private String qrCode;
    private String eventName;
    private String ticketType;
    private double price;
    private boolean valid;
}