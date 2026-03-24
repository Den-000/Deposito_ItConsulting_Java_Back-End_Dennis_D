package d24M03Y2026.afternoon.videogameDevelopmentHouseManager.view;

import java.util.ArrayList;
import java.util.Scanner;
import d24M03Y2026.afternoon.videogameDevelopmentHouseManager.model.*;

// Classe View: gestisce input/output con l'utente
public class View {

    private Scanner sc = new Scanner(System.in);

    // Mostra il menu principale e restituisce la scelta
    public int showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1) Assegna gioco");
        System.out.println("2) Visualizza team");
        System.out.println("3) Gioco più costoso");
        System.out.println("4) Modifica stato gioco");
        System.out.println("5) Aggiungi sviluppatore");
        System.out.println("6) Esci");
        System.out.println("================\n");
        System.out.println("Opzione scelta: ");

        // Controllo sulla scelta (input)
        while (true) {
            try {
                String input = sc.nextLine();
                int choice = Integer.parseInt(input); // Converte stringa in int
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero intero valido.");
            }
        }
    }

    // Seleziona un team (1-3) con validazione
    public int selectTeam() {
        System.out.print("\nSeleziona team (1-3): ");
        while (true) {
            try {
                String input = sc.nextLine();
                int value = Integer.parseInt(input);
                if(value < 1 || value > 3){
                    System.out.println("Valore inserito non valido");
                } else {
                    return (value - 1); // Restituisce indice 0-based
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero intero valido.");
            }
        }
    }

    // Crea un nuovo gioco chiedendo i dati all'utente
    public Game createGame() {
        System.out.print("Titolo: ");
        String title = sc.nextLine();

        System.out.print("Genere: ");
        String genre = sc.nextLine();

        System.out.print("Costo di sviluppo: ");
        double cost;
        // Controllo sul prezzo (input)
        while (true) {
            try {
                String input = sc.nextLine();
                cost = Double.parseDouble(input); // Converte stringa in double
                break;
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero decimale valido.");
            }
        }

        System.out.print("Stato: ");
        String status = sc.nextLine();

        return new Game(title, genre, cost, status);
    }

    // Crea un nuovo sviluppatore chiedendo i dati all'utente
    public Developer createDeveloper() {
        System.out.print("Nome sviluppatore: ");
        String name = sc.nextLine();

        System.out.print("Ruolo: ");
        String role = sc.nextLine();

        return new Developer(name, role);
    }

    // Mostra la lista dei team con i loro dettagli
    public void showTeams(ArrayList<Team> teams) {
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("\n[" + (i + 1) + "] " + teams.get(i));
        }
    }

    // Stampa un messaggio a video
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    // Richiede una stringa all'utente
    public String askString(){
        return sc.nextLine();
    }
}