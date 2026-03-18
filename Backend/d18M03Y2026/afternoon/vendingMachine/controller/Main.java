package d18M3Y2026.afternoon.vendingMachine.controller;

import d18M3Y2026.afternoon.vendingMachine.view.*;
import d18M3Y2026.afternoon.vendingMachine.utility.*;

public class Main {
    public static void main(String[] args) {
        boolean loop = true;
        int choice;
        double amountAvaible = 0;

        do {
            View.print("\n========== MENU ==========\n");
            View.print("1) Caffè → 1.50€\n");
            View.print("2) Cappuccino → 2.00€\n");
            View.print("3) Thé → 1.00€\n");
            View.print("4) Acqua → 0.50€\n");
            View.print("5) Inserisci credito\n");
            View.print("6) Eroga credito residuo\n");
            View.print("7) Esci\n");
            View.separationBar();
            View.print("\nCredito disponibile: " + amountAvaible + "€ \n\n");
            View.print("Scelta: \n");
            View.print("(n.b. Scrivi il numero della scenta per acquistare, inserire credito, chiedere il credito residuo od uscire)\n\n");
            choice = Utility.askInt();
            switch (choice) {
                case 1:
                    amountAvaible = buy(amountAvaible, 1.50);
                    break;
                case 2:
                    amountAvaible = buy(amountAvaible, 2.00);
                    break;
                case 3:
                    amountAvaible = buy(amountAvaible, 1.00);
                    break;
                case 4:
                    amountAvaible = buy(amountAvaible, 0.50);
                    break;
                case 5: // Inserisci credito
                View.print("\nQuanto credito vuoi inserire? \n");
                amountAvaible = deposit(Utility.askDouble());
                    break;
                case 6:
                    amountAvaible = 0;
                    View.print("Credito erogato con successo!\n");
                    break;

                case 7:
                    loop = false;
                    View.print("Arrivederci!");
                    break;
            
                default:
                    break;
            }
        } while (loop);
    }


    public static double buy(double amountAvaible, double price){
        if (amountAvaible > 0 && amountAvaible > price) {
            amountAvaible = (amountAvaible - price);
            View.print("\n\nAcquisto avvenuto con successo!\n\n");
        } else {
            View.print("\n\nCredito insufficiente\n\n");
        }
        return amountAvaible;
    }

    public static double deposit(double amountToDeposit){
        double creditEntered = 0;
        if(amountToDeposit <= 0){
            View.print("\n\nCredito non valido\n\n");
        } else {
            creditEntered = amountToDeposit;
            View.print("\n\nCredito aggiunto con successo\n\n");
        }
        return creditEntered;
    }
}