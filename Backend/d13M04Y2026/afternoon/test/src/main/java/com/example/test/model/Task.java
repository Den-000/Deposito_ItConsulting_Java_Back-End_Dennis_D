package com.example.test.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // genera getter, setter, toString, equals, hashCode
@NoArgsConstructor // costruttore vuoto
@AllArgsConstructor // costruttore con tutti i campi
public class Task {

    // ID univoco del task
    private Long id;

    // Titolo del task
    private String name;

    // Descrizione dettagliata
    private String description;

    // Stato del task (state machine)
    private TaskStatus status;

    // Priorità:
    // 1 = alta urgenza
    // 3 = bassa urgenza
    private int priority;

    // Data entro cui il task deve essere completato
    private LocalDate expirationDate;
}