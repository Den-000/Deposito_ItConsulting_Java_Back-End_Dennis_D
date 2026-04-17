package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final EventRepository eventRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final TicketRepository ticketRepository;
    private final PaymentRepository paymentRepository;
    private final MyUserRepository userRepository;
    private final EmailService emailService;
    private final QRCodeService qrCodeService;

    public TicketResponse bookTicket(TicketRequest request) {

        // 1. EVENTO
        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new RuntimeException("Evento non trovato"));

        if (event.getStatus() != EventStatus.ACTIVE) {
            throw new RuntimeException("Evento non attivo");
        }

        if (event.getBookedSeats() >= event.getMaxSeats()) {
            throw new RuntimeException("Evento sold out");
        }

        // 2. TICKET TYPE
        TicketType type = ticketTypeRepository.findById(request.getTicketTypeId())
                .orElseThrow(() -> new RuntimeException("Ticket type non trovato"));

        if (type.getAvailableSeats() <= 0) {
            throw new RuntimeException("Biglietti esauriti per questo tipo");
        }

        // 3. USER (opzionale se vuoi login)
        MyUser user = userRepository.findByUsername(request.getEmail())
                .orElse(null);

        // 4. QR CODE
        String qr = qrCodeService.generate();

        // 5. TICKET
        Ticket ticket = new Ticket();
        ticket.setEvent(event);
        ticket.setTicketType(type);
        ticket.setQrCode(qr);
        ticket.setUser(user);
        ticket.setEmail(user.getUsername());
        ticket.setValid(true);
        ticket.setCheckedIn(false);
        ticket.setPurchaseDate(LocalDateTime.now());

        // 6. UPDATE SEATS
        event.setBookedSeats(event.getBookedSeats() + 1);
        type.setAvailableSeats(type.getAvailableSeats() - 1);

        // 7. PAYMENT SIMULATO
        Payment payment = new Payment();
        payment.setAmount(type.getPrice());
        payment.setStatus(PaymentStatus.PAID);
        payment.setMethod("CARD");
        payment.setPaymentDate(LocalDateTime.now());

        payment.setTicket(ticket);
        ticket.setPayment(payment);

        // 8. SAVE
        ticketRepository.save(ticket);
        paymentRepository.save(payment);

        // 9. EMAIL
        emailService.sendTicket(request.getEmail(), qr);

        // 10. RESPONSE
        return TicketResponse.builder()
                .qrCode(qr)
                .eventName(event.getName())
                .ticketType(type.getName())
                .price(type.getPrice())
                .valid(true)
                .build();
    }

    public void checkIn(CheckInRequest request) {

        Ticket ticket = ticketRepository.findByQrCode(request.getQrCode())
                .orElseThrow(() -> new RuntimeException("Ticket non trovato"));

        if (!ticket.isValid()) {
            throw new RuntimeException("Ticket non valido");
        }

        if (ticket.isCheckedIn()) {
            throw new RuntimeException("Già usato");
        }

        ticket.setCheckedIn(true);

        // log automatico (bonus)
        System.out.println("Check-in effettuato per ticket " + ticket.getId());
    }
}