package d24M03Y2026.afternoon.videogameDevelopmentHouseManager.model;

// Classe Game: rappresenta un videogioco
public class Game {
    private String title;             // Titolo del gioco
    private String genre;             // Genere del gioco
    private double developmentCost;   // Costo di sviluppo
    private String status;            // Stato attuale del gioco

    // Costruttore
    public Game(String title, String genre, double developmentCost, String status) {
        this.title = title;
        this.genre = genre;
        this.developmentCost = developmentCost;
        this.status = status;
    }

    // ===== GETTER =====
    public String getTitle() { 
        return title; 
    }
    public double getDevelopmentCost() { 
        return developmentCost; 
    }
    public String getStatus() { 
        return status; 
    }

    // ===== SETTER =====
    public void setStatus(String status) { 
        this.status = status; 
    }

    // Rappresentazione testuale del gioco
    public String toString() {
        return "Titolo: " + title +
               " - Genere: " + genre +
               " - Costo di sviluppo: " + developmentCost +
               " - Stato: " + status;
    }
}