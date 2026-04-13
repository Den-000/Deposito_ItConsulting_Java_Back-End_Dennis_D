package com.example.test.model;

// Rappresenta i possibili stati di un task
public enum TaskStatus {

    // Task appena creato, non ancora iniziato
    TODO,

    // Task in lavorazione
    IN_PROGRESS,

    // Task completato
    DONE,

    // Task annullato
    CANCELLED
}