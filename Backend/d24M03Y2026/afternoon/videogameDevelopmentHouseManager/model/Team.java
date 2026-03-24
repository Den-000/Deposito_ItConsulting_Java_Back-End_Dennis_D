package d24M03Y2026.afternoon.videogameDevelopmentHouseManager.model;

import java.util.ArrayList;

// Classe Team: rappresenta un team di sviluppo
public class Team {
    private String name;                    // Nome del team
    private ArrayList<Developer> developers;// Lista degli sviluppatori
    private Game game;                      // Gioco assegnato al team

    // Costruttore
    public Team(String name) {
        this.name = name;
        this.developers = new ArrayList<>();
    }

    // Assegna un gioco al team
    public void assignGame(Game game) {
        this.game = game;
    }

    // Restituisce il gioco assegnato
    public Game getGame() {
        return game;
    }

    // Restituisce il nome del team
    public String getName() {
        return name;
    }

    // Restituisce la lista di sviluppatori
    public ArrayList<Developer> getDevelopers() {
        return developers;
    }

    // Aggiunge uno sviluppatore al team
    public void addDeveloper(Developer d) {
        developers.add(d);
    }

    // Rappresentazione testuale del team, gioco e sviluppatori
    public String toString() {
        String gameInfo = (game != null) ? game.toString() : "Nessun gioco assegnato";

        return "\nTeam: " + name +
               "\nNumero sviluppatori: " + developers.size() +
               "\nGioco → " + gameInfo +
               "\nSviluppatori: " + developers;
    }
}