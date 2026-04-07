package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection instance; // Singleton instance
    private Connection connection;           // Connessione unica

    // Parametri DB
    private final String URL = "jdbc:mysql://localhost:3306/dbmanager_itconsulting"; 
    private final String USER = "root";
    private final String PASSWORD = "root";

    // Costruttore privato
    private DbConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connessione al database stabilita!");
        } catch (SQLException e) {
            throw new SQLException("Errore connessione: " + e.getMessage());
        }
    }

    // Metodo statico per ottenere l'unica istanza
    public static DbConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DbConnection(); // ricrea la connessione se chiusa
        }
        return instance;
    }

    // Restituisce la connessione
    public Connection getConnection() {
        return connection;
    }
}