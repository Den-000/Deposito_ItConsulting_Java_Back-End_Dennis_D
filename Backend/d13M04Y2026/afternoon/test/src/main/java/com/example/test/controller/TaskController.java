package com.example.test.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.example.test.model.Task;
import com.example.test.model.TaskStatus;

@RestController // Espone la classe come REST API
@RequestMapping("/tasks") // Base URL per tutti gli endpoint
public class TaskController {

    // Simulazione database in memoria (non persistente)
    private List<Task> tasks = new ArrayList<>();

    // Contatore per generare ID univoci
    private long idCounter = 1;

    // =========================
    // CREATE TASK
    // =========================
    @PostMapping
    public Object addTask(@RequestBody Task task) {

        // Controllo: non si possono creare task con data scadenza nel passato
        if (task.getExpirationDate().isBefore(LocalDate.now())) {
            return "Errore: la data di scadenza non può essere nel passato";
        }

        // Generazione ID automatico
        task.setId(idCounter++);

        // Stato iniziale fisso (state machine)
        task.setStatus(TaskStatus.TODO);

        // Aggiunta alla lista
        tasks.add(task);

        return task;
    }

    // =========================
    // GET ALL (con filtri & sorting)
    // =========================
    @GetMapping
    public List<Task> getAll(
            @RequestParam(required = false) TaskStatus status, // filtro opzionale stato
            @RequestParam(required = false) String search) {   // filtro opzionale testo

        return tasks.stream()

                // filtro per stato
                .filter(t -> t.getStatus() == status)

                // filtro per nome (case-insensitive)
                .filter(t -> t.getName().toLowerCase().contains(search.toLowerCase()))

                // ordinamento:
                // 1. priorità crescente (1 = più urgente)
                // 2. a parità, ordine alfabetico
                .sorted((t1, t2) -> {
                    int compare = Integer.compare(t1.getPriority(), t2.getPriority());
                    if (compare == 0) {
                        return t1.getName().compareToIgnoreCase(t2.getName());
                    }
                    return compare;
                })

                .collect(Collectors.toList());
    }

    // =========================
    // GET TASK BY ID
    // =========================
    @GetMapping("/get")
    public Task getById(@RequestParam Long id) {

        // Cerca task per ID, se non trovato ritorna null
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // =========================
    // UPDATE TASK
    // =========================
    @PutMapping("/modify")
    public Object modifyTask(@RequestParam Long id, @RequestBody Task updatedTask) {

        // Scorre tutti i task per trovare quello da aggiornare
        for (Task t : tasks) {

            if (t.getId().equals(id)) {

                // =========================
                // STATE MACHINE VALIDATION
                // =========================
                if (!isValidTransition(t.getStatus(), updatedTask.getStatus())) {
                    return "Errore: Transizione di stato non consentita";
                }

                // =========================
                // VALIDAZIONE DATA
                // =========================
                if (updatedTask.getExpirationDate().isBefore(LocalDate.now())) {
                    return "Errore: data scadenza non valida";
                }

                // Aggiornamento campi
                t.setName(updatedTask.getName());
                t.setDescription(updatedTask.getDescription());
                t.setPriority(updatedTask.getPriority());
                t.setExpirationDate(updatedTask.getExpirationDate());
                t.setStatus(updatedTask.getStatus());

                return "Task aggiornato con successo";
            }
        }

        // Se non trova il task
        return "Task non trovato";
    }

    // =========================
    // STATE MACHINE (regole di transizione stato)
    // =========================
    private boolean isValidTransition(TaskStatus current, TaskStatus next) {

        // Da TO DO si può andare solo a IN_PROGRESS o CANCELLED
        if (current == TaskStatus.TODO) {
            return next == TaskStatus.IN_PROGRESS || next == TaskStatus.CANCELLED;
        }

        // Da IN_PROGRESS si può andare solo a DONE o CANCELLED
        if (current == TaskStatus.IN_PROGRESS) {
            return next == TaskStatus.DONE || next == TaskStatus.CANCELLED;
        }

        // Da DONE o CANCELLED non si può più cambiare stato
        return false;
    }

    // =========================
    // TASK SCADUTI
    // =========================
    @GetMapping("/expiredTasks")
    public List<Task> getExpiredTasks() {

        return tasks.stream()

                // task con data scadenza passata
                .filter(t -> t.getExpirationDate().isBefore(LocalDate.now()))

                // ma non completati
                .filter(t -> t.getStatus() != TaskStatus.DONE)

                .collect(Collectors.toList());
    }

    // =========================
    // DELETE TASK
    // =========================
    @DeleteMapping("/delete")
    public String deleteTask(@RequestParam Long id) {

        // Rimuove task con ID corrispondente
        tasks.removeIf(task -> task.getId().equals(id));

        return "Task con id: " + id + " eliminato";
    }
}