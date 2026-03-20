package d20M03Y2026.afternoon.carManager.controller;

import java.util.ArrayList;
import d20M03Y2026.afternoon.carManager.model.Vehicle;
import d20M03Y2026.afternoon.carManager.utility.Utility;
import d20M03Y2026.afternoon.carManager.view.View;

// Classe principale del gestore veicoli
public class Main {

    // Lista globale che contiene tutti i veicoli inseriti
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        // Ciclo principale: mostra menu finché l'utente non decide di uscire
        do {
            View.showMenu();                  // Mostra le opzioni del menu
            View.showMessage("Scelta: ");
            choice = Utility.askInt();        // Chiede all'utente una scelta numerica

            // Gestione delle varie opzioni del menu
            switch (choice) {

                case 1:
                    addVehicle();            // Aggiunge un nuovo veicolo
                    break;

                case 2:
                    showVehicles();          // Mostra tutti i veicoli
                    break;

                case 3:
                    updatePrice();           // Aggiorna il prezzo di un veicolo
                    break;

                case 4:
                    checkVehicleAge();       // Controlla l’età del veicolo
                    break;

                case 5:
                    View.showMessage("Uscita...");  // Termina il programma
                    break;

                default:
                    View.showMessage("Scelta non valida"); // Gestione errore
            }

        } while (choice != 5);  // Continua finché l’utente non sceglie 5
    }

    // ======================
    // METODI PER LA GESTIONE DEI VEICOLI
    // ======================

    // Aggiunge un nuovo veicolo alla lista
    static void addVehicle() {
        // Chiede all’utente i dettagli del veicolo
        String brand = Utility.askString("Marca: ");
        String model = Utility.askString("Modello: ");
        int year = Utility.askInt("Anno: ", 1900, 3000);          // Controllo range anno
        double price = Utility.askDouble("Prezzo: ", 0.01, 10000); // Controllo range prezzo

        // Crea un nuovo veicolo e lo aggiunge alla lista
        vehicles.add(new Vehicle(brand, model, year, price));
        View.showMessage("Veicolo aggiunto!");
    }

    // Mostra tutti i veicoli presenti
    public static void showVehicles() {
        if (vehicles.isEmpty()) {               // Controlla se la lista è vuota
            View.showMessage("Nessun veicolo.");
            return;
        }

        // Stampa i dettagli di ogni veicolo con il suo indice
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);
            View.printDetails(i, v.getBrand(), v.getModel(), v.getYear(), v.getPrice());
        }
    }

    // Aggiorna il prezzo di un veicolo selezionato
    static void updatePrice() {
        if (vehicles.isEmpty()) {               // Controlla lista vuota
            View.showMessage("Nessun veicolo.");
            return;
        }

        showVehicles();  // Mostra veicoli per permettere la selezione
        int index = Utility.askInt("Seleziona indice: ", 0, vehicles.size() - 1); // Selezione con controllo range
        double newPrice = Utility.askDouble("Nuovo prezzo: ", 0.01, 10000);       // Nuovo prezzo valido

        vehicles.get(index).setPrice(newPrice);   // Aggiorna prezzo
        View.showMessage("Prezzo aggiornato.");
    }

    // Controlla l’età di un veicolo e ne determina lo stato
    static void checkVehicleAge() {
        if (vehicles.isEmpty()) {               // Controlla lista vuota
            View.showMessage("Nessun veicolo.");
            return;
        }

        showVehicles();  // Mostra veicoli per permettere la selezione
        int index = Utility.askInt("Seleziona indice: ", 0, vehicles.size() - 1);

        int currentYear = 2026;                      // Anno corrente
        int age = currentYear - vehicles.get(index).getYear(); // Calcola età del veicolo

        View.showMessage("Età: " + age);

        // Determina lo stato del veicolo in base all’età
        if (age < 5)
            View.showMessage("Nuova");
        else if (age <= 15)
            View.showMessage("Usata");
        else
            View.showMessage("Vecchia");
    }
}