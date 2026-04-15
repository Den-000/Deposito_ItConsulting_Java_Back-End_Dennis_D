package com.security.test.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.security.test.model.MyUser;

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
}