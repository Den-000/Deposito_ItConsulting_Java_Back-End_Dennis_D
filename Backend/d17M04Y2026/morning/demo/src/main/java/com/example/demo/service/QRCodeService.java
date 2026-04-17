package com.example.demo.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class QRCodeService {

    public String generate() {
        return UUID.randomUUID().toString();
    }
}