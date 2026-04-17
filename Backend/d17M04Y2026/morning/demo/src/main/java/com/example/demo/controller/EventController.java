package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Page<Event> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/search")
    public List<Event> getByName(@RequestParam String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }
}