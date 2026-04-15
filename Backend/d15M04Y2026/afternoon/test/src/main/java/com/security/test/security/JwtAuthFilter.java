package com.security.test.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * FILTRO JWT:
 *
 * Intercetta OGNI richiesta HTTP e:
 * 1. legge header Authorization
 * 2. estrae JWT
 * 3. valida token
 * 4. autentica utente nel SecurityContext
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userService;

    public JwtAuthFilter(JwtService jwtService,
                         CustomUserDetailsService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    /**
     * Esclude endpoint pubblici (es. /auth/**)
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().startsWith("/auth/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        // legge header Authorization
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {

            // estrae token
            String token = header.substring(7);

            // estrae username dal JWT
            String username = jwtService.extractUsername(token);

            if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

                // carica utente dal DB
                UserDetails user = userService.loadUserByUsername(username);

                // crea autenticazione Spring
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(
                                user, null, user.getAuthorities());

                // salva nel contesto sicurezza
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        // continua catena filtri
        chain.doFilter(request, response);
    }
}