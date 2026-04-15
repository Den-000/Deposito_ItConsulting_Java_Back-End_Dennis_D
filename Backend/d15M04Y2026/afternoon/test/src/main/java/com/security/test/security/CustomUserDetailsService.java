package com.security.test.security;

import com.security.test.model.MyUser;
import com.security.test.repository.MyUserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

/**
 * Ponte tra database e Spring Security.
 *
 * Converte un utente DB in UserDetails (formato richiesto da Spring).
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MyUserRepository repo;

    public CustomUserDetailsService(MyUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        // recupera utente dal DB
        MyUser user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // converte in oggetto compatibile con Spring Security
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole()) // Spring aggiunge ROLE_
                .build();
    }
}