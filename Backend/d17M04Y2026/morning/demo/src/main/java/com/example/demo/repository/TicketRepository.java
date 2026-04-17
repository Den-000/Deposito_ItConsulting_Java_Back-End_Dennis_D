package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Event;
import com.example.demo.model.MyUser;
import com.example.demo.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByEvent(Event event);

    List<Ticket> findByUser(MyUser user);

    Optional<Ticket> findByQrCode(String qrCode);

    long countByEventId(Long eventId);

    long countByEventIdAndCheckedInTrue(Long eventId);
}