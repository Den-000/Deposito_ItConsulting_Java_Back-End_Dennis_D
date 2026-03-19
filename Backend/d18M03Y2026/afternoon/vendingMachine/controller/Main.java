package d18M03Y2026.afternoon.vendingMachine.controller; // Dichiarazione package

// Import delle classi per interfaccia utente ed utilità
import d18M03Y2026.afternoon.vendingMachine.view.*;
import d18M03Y2026.afternoon.vendingMachine.utility.*;

public class Main {
    public static void main(String[] args) {

        boolean loop = true; // Controlla il ciclo principale del programma
        int choice; // Scelta dell'utente
        double amountAvaible = 0; // Credito disponibile nel distributore

        // CICLO PRINCIPALE (menu)
        do {
            // Stampa menu
            View.print("\n========== MENU ==========\n");
            View.print("1) Caffè → 1.50€\n");
            View.print("2) Cappuccino → 2.00€\n");
            View.print("3) Thé → 1.00€\n");
            View.print("4) Acqua → 0.50€\n");
            View.print("5) Inserisci credito\n");
            View.print("6) Eroga credito residuo\n");
            View.print("7) Esci\n");
            View.separationBar();

            // Mostra credito attuale
            View.print("\nCredito disponibile: " + amountAvaible + "€ \n\n");

            // Richiesta scelta utente
            View.print("Scelta: \n");
            View.print("(n.b. Inserisci il numero dell'operazione)\n\n");

            choice = Utility.askInt(); // Input sicuro (gestito da Utility)

            // Gestione scelta tramite switch
            switch (choice) {

                case 1: // Acquisto caffè
                    amountAvaible = buy(amountAvaible, 1.50);
                    break;

                case 2: // Acquisto cappuccino
                    amountAvaible = buy(amountAvaible, 2.00);
                    break;

                case 3: // Acquisto tè
                    amountAvaible = buy(amountAvaible, 1.00);
                    break;

                case 4: // Acquisto acqua
                    amountAvaible = buy(amountAvaible, 0.50);
                    break;

                case 5: // Inserimento credito
                    View.print("\nQuanto credito vuoi inserire? \n");
                    amountAvaible = deposit(Utility.askDouble());
                    break;

                case 6: // Restituzione credito
                    amountAvaible = 0;
                    View.print("Credito erogato con successo!\n");
                    break;

                case 7: // Uscita dal programma
                    loop = false;
                    View.print("Arrivederci!");
                    break;

                default:
                    View.print("Scelta non valida\n");
            }

        } while (loop);
    }

    // Metodo per effettuare un acquisto
    public static double buy(double amountAvaible, double price){

        // Controlla se il credito è sufficiente
        if (amountAvaible > 0 && amountAvaible >= price) {
            amountAvaible = (amountAvaible - price); // Scala il prezzo dal credito
            View.print("\n\nAcquisto avvenuto con successo!\n\n");
        } else {
            View.print("\n\nCredito insufficiente\n\n");
        }

        return amountAvaible; // Restituisce il credito aggiornato
    }

    // Metodo per inserire credito
    public static double deposit(double amountToDeposit){

        double creditEntered = 0;

        // Controllo validità importo
        if(amountToDeposit <= 0){
            View.print("\n\nCredito non valido\n\n");
        } else {
            creditEntered = amountToDeposit; // Imposta il credito inserito
            View.print("\n\nCredito aggiunto con successo\n\n");
        }

        return creditEntered; // Restituisce il credito inserito
    }
}