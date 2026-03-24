package d24M03Y2026.afternoon.videogameDevelopmentHouseManager.controller;

import java.util.ArrayList;
import d24M03Y2026.afternoon.videogameDevelopmentHouseManager.model.*;
import d24M03Y2026.afternoon.videogameDevelopmentHouseManager.view.View;

// Classe principale che gestisce il flusso del programma
public class Main {
    public static void main(String[] args) {

        // MODEL: creazione dei team
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(new Team("UbiSoft"));
        teams.add(new Team("FromSoftware"));
        teams.add(new Team("CapCom"));

        // CONTROLLER: gestisce la logica tra team, giochi e sviluppatori
        Controller controllerObj = new Controller(teams);

        // VIEW: gestione input/output
        View viewObj = new View();

        int choice;
        int selectedTeam;

        // Ciclo principale del menu
        do {
            choice = viewObj.showMenu();

            switch (choice) {

                case 1: // Assegna gioco ad un team
                    selectedTeam = viewObj.selectTeam();
                    Game newGame = viewObj.createGame();
                    controllerObj.assignGameToTeam(selectedTeam, newGame);
                    viewObj.showMessage("\nGioco assegnato!");
                    break;

                case 2: // Visualizza tutti i team
                    viewObj.showTeams(controllerObj.getTeams());
                    break;

                case 3: // Mostra gioco più costoso in termini di sviluppo
                    Game mostExpensiveGame = controllerObj.getMostExpensiveGame();
                    if (mostExpensiveGame != null)
                        viewObj.showMessage("\nGioco più costoso:\n" + mostExpensiveGame);
                    else
                        viewObj.showMessage("Nessun gioco presente");
                    break;

                case 4: // Modifica stato gioco
                    selectedTeam = viewObj.selectTeam();
                    viewObj.showMessage("Nuovo stato:");
                    String status = viewObj.askString();
                    controllerObj.updateGameStatus(selectedTeam, status);
                    break;

                case 5: // Aggiungi sviluppatore ad un team
                    selectedTeam = viewObj.selectTeam();
                    Developer developer = viewObj.createDeveloper();
                    controllerObj.addDeveloperToTeam(selectedTeam, developer);
                    viewObj.showMessage("Sviluppatore aggiunto!");
                    break;

                case 6: // Esci
                    viewObj.showMessage("Uscita...");
                    break;

                default:
                    viewObj.showMessage("Scelta non valida");
            }

        } while (choice != 6); // Termina quando si sceglie 6
    }
}