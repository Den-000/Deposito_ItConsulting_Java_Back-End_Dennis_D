package d24M03Y2026.afternoon.videogameDevelopmentHouseManager.controller;

import java.util.ArrayList;
import d24M03Y2026.afternoon.videogameDevelopmentHouseManager.model.Developer;
import d24M03Y2026.afternoon.videogameDevelopmentHouseManager.model.Game;
import d24M03Y2026.afternoon.videogameDevelopmentHouseManager.model.Team;

// Classe Controller: gestisce la logica applicativa tra Team, Game e Developer
public class Controller {

    private ArrayList<Team> teams; // Lista dei team

    // Costruttore: inizializza il controller con i team
    public Controller(ArrayList<Team> teams) {
        this.teams = teams;
    }

    // Assegna un gioco ad un team dato l'indice
    public void assignGameToTeam(int index, Game game) {
        if (index >= 0 && index < teams.size()) {
            teams.get(index).assignGame(game);
        }
    }

    // Aggiunge uno sviluppatore ad un team dato l'indice
    public void addDeveloperToTeam(int index, Developer dev) {
        if (index >= 0 && index < teams.size()) {
            teams.get(index).addDeveloper(dev);
        }
    }

    // Aggiorna lo stato del gioco di un team dato l'indice
    public void updateGameStatus(int index, String newStatus) {
        if (index >= 0 && index < teams.size()) {
            Game g = teams.get(index).getGame();
            if (g != null) {
                g.setStatus(newStatus);
            }
        }
    }

    // Restituisce il gioco con il costo di sviluppo più alto tra tutti i team
    public Game getMostExpensiveGame() {
        Game max = null;

        for (Team t : teams) {
            if (t.getGame() != null) {
                if (max == null || t.getGame().getDevelopmentCost() > max.getDevelopmentCost()) {
                    max = t.getGame();
                }
            }
        }
        return max;
    }

    // Restituisce la lista dei team
    public ArrayList<Team> getTeams() {
        return teams;
    }
}