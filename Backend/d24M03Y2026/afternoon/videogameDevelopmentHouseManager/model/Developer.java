package d24M03Y2026.afternoon.videogameDevelopmentHouseManager.model;

// Classe Developer: rappresenta uno sviluppatore
public class Developer {
    private String name; // Nome dello sviluppatore
    private String role; // Ruolo nello sviluppo

    // Costruttore
    public Developer(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Rappresentazione testuale dello sviluppatore
    public String toString() {
        return name + " (" + role + ")";
    }
}