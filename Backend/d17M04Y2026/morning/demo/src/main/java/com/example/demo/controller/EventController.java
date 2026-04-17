package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventRepository repo;

    @PostMapping
    public Event create(@RequestBody Event event) {
        return repo.save(event);
    }

    @GetMapping("/all")
    public List<Event> getAll() {
        return repo.findAll();
    }

    // endpoint to get events by name
    @GetMapping("/search")
    public Optional<Event> getByName(@RequestBody String name) {
        return repo.findByName(name);
    }
}