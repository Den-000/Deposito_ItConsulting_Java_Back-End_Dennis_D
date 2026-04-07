package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
    
    private Connection connection;

    public UserManager() {
        try {
            this.connection = DbConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Tentativo di connessione al DB fallito", e);
        }
    }

    // Metodo per verificare le credenziali dell'utente
    public boolean login(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Se c'è un risultato, login è riuscito

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo per la creazione di un nuovo utente
    public boolean createUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Se è stato inserito almeno un record, la creazione è riuscita
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo per la modifica del nome utente
    public boolean updateUserUsername(String oldUsername, String newUsername) {
        String query = "UPDATE users SET username = ? WHERE username = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newUsername);
            stmt.setString(2, oldUsername);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Se è stato aggiornato almeno un record, la modifica è riuscita
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo per la modifica della password dell'utente
    public boolean updateUserPassword(String username, String newPassword) {
        String query = "UPDATE users SET password = ? WHERE username = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, username);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Se è stato aggiornato almeno un record, la modifica è riuscita
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo per eliminare un utente
    public boolean deleteUser(String username) {
        String query = "DELETE FROM users WHERE username = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Se è stato eliminato almeno un record, la cancellazione è riuscita
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
