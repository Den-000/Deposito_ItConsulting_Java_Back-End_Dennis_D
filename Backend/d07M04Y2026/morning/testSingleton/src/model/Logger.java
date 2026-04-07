package model;

public class Logger {

    // Istanza unica
    private static Logger instance;

    // Costruttore privato
    private Logger() {}

    // Metodo per ottenere l'unica istanza
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}