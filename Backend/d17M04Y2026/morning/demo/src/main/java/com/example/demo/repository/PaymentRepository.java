package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Payment;
import com.example.demo.model.Ticket;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByTicket(Ticket ticket);
}