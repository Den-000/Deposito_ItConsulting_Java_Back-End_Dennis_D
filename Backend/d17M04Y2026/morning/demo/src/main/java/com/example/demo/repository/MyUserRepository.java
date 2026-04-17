package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MyUser;

/**
 * Repository JPA per accesso al database utenti.
 *
 * Spring genera automaticamente l'implementazione.
 */
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    /**
     * Query derivata:
     * SELECT * FROM users WHERE username = ?
     */
    Optional<MyUser> findByUsername(String username);

    boolean existsByUsername(String username);
}