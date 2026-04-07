package dao;

import java.sql.*;

class DBConnection {

    // Istanza singleton
    private static DBConnection instance;

    // Connessione al DB
    private Connection connection;

    // Parametri di connessione
    private final String URL = "jdbc:mysql://localhost:3306/orderobserver_itconsulting"; 
    private final String USER = "root";
    private final String PASSWORD = "root";

    // Costruttore privato (pattern Singleton)
    private DBConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connessione al DB stabilita.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Restituisce l'istanza singleton
    public static DBConnection getInstance() throws SQLException {

        // Se non esiste, la crea
        if (instance == null) {
            instance = new DBConnection();

        // Se la connessione è chiusa, la ricrea
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }

        return instance;
    }

    // Restituisce la connessione
    public Connection getConnection() {
        return connection;
    }
}