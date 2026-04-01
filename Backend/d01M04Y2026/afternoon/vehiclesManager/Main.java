package vehiclesManager;

import java.util.ArrayList;
import java.util.Scanner;

import vehiclesManager.interfaces.*;
import vehiclesManager.model.*;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<VeicoloConsegna> veicoli = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int scelta;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Aggiungi Furgone");
            System.out.println("2. Aggiungi Drone");
            System.out.println("3. Effettua consegne");
            System.out.println("0. Esci");
            System.out.println("============");
            System.out.println("Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                // Aggiungi furgone
                case 1:
                    System.out.print("Inserisci targa: ");
                    String targaF = scanner.nextLine();
                    System.out.print("Carico massimo: ");
                    float caricoF = scanner.nextFloat();
                    veicoli.add(new Furgone(targaF, caricoF));
                    break;
                // Aggiungi drone
                case 2:
                    System.out.print("Inserisci codice drone: ");
                    String targaD = scanner.nextLine();
                    System.out.print("Carico massimo: ");
                    float caricoD = scanner.nextFloat();
                    veicoli.add(new Drone(targaD, caricoD));
                    break;
                // Effettua consegne
                case 3:
                    for (VeicoloConsegna v : veicoli) {
                        v.stampaInfo();

                        System.out.print("Destinazione: ");
                        String dest = scanner.nextLine();

                        System.out.print("Peso pacco: ");
                        float peso = scanner.nextFloat();
                        scanner.nextLine();

                        v.consegnaPacco(dest, peso);

                        // Traccia consegna solo per i veicoli che implementano Tracciabile
                        if (v instanceof Tracciabile) {
                            ((Tracciabile) v).tracciaConsegna("ABC123");
                        }
                    }
                    break;
            }

        } while (scelta != 0);

        scanner.close();
    }
}