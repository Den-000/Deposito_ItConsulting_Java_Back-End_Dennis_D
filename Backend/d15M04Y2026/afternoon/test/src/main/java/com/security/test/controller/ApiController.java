package com.security.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Controller di test security.
 *
 * Questo controller espone endpoint protetti da Spring Security + JWT.
 */
@RestController // indica che questa classe espone API REST
@RequestMapping("/api") // prefisso comune per tutti gli endpoint
public class ApiController {

    /**
     * Endpoint pubblico (ma comunque richiede autenticazione globale, poiché così configurata).
     *
     * GET /api/hello
     */
    @GetMapping("/hello")
    public String hello() {
        // risposta semplice per verificare che l'utente sia autenticato
        return "USER OK";
    }

    /**
     * Endpoint protetto a livello di ruolo.
     *
     * @PreAuthorize:
     * - viene valutato PRIMA dell'esecuzione del metodo
     * - richiede che l'utente abbia il ruolo ADMIN
     *
     * GET /api/admin
     */
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "ADMIN OK";
    }
}