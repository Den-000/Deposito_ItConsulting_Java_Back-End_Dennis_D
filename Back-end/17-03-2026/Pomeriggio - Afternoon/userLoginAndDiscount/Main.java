package userLoginAndDiscount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Scanner per leggere input da tastiera
        boolean loop = true; // Controlla il ciclo principale del menu
        int choice; // Variabile per memorizzare la scelta dell'utente

        // CICLO PRINCIPALE
        while (loop) {

            // Stampa menu principale
            System.out.println("===========================");
            System.out.println("1) Controllo Username");
            System.out.println("2) Login");
            System.out.println("3) Sconto");
            System.out.println("4) Esci");
            System.out.println("===========================");

            System.out.print("\nLa mia scelta è: ");

            try {
                choice = input.nextInt(); // Legge scelta numerica
                input.nextLine(); // Pulisce il buffer

                switch (choice) {

                    case 1:
                        // PROGRAMMA 1: CONTROLLO USERNAME
                        System.out.print("Inserisci username: ");
                        String username = input.nextLine();

                        // Controllo validità username
                        if (username.isEmpty()) {
                            System.out.println("Username non valido (vuoto)\n");
                        } else if (username.length() < 5) {
                            System.out.println("Username troppo corto\n");
                        } else {
                            System.out.println("Username valido\n");
                        }
                        break;

                    case 2:
                        // PROGRAMMA 2: LOGIN
                        String userCorrerct = "admin"; // Username corretto
                        String passCorrerct = "1234";  // Password corretta

                        System.out.print("Inserisci username: ");
                        String userInput = input.nextLine();

                        System.out.print("Inserisci password: ");
                        String passInput = input.nextLine();

                        boolean userOk = userInput.equalsIgnoreCase(userCorrerct); // Controllo username
                        boolean passOk = passInput.equals(passCorrerct);           // Controllo password

                        // Verifica credenziali
                        if (userOk && passOk) {
                            System.out.println("Accesso consentito\n");
                        } else if (!userOk && !passOk) {
                            System.out.println("Accesso negato\n");
                        } else {
                            System.out.println("Credenziali errate\n");
                        }
                        break;

                    case 3:
                        // PROGRAMMA 3: SCONTO
                        System.out.print("Inserisci codice sconto: ");
                        String code = input.nextLine();

                        System.out.print("Inserisci importo totale: ");
                        double amount = input.nextDouble();
                        input.nextLine();

                        // Conversione importo in stringa
                        String stringAmount = String.valueOf(amount);
                        System.out.println("Importo come stringa: " + stringAmount);

                        double finalAmount = amount;
                        boolean valid = true;

                        // Controllo codice sconto
                        if (code.equals("SCONTO10")) {
                            finalAmount = amount * 0.9; // 10% sconto
                        } else if (code.equals("SCONTO20")) {
                            finalAmount = amount * 0.8; // 20% sconto
                        } else if (code.equals("VIP")) {
                            if (amount > 100) {        // VIP valido solo sopra 100€
                                finalAmount = amount * 0.7; // 30% sconto
                            } else {
                                System.out.println("Codice VIP valido solo sopra i 100€\n");
                                valid = false;
                            }
                        } else {
                            System.out.println("Codice non valido\n");
                            valid = false;
                        }

                        if (valid) {
                            System.out.println("Prezzo scontato: " + finalAmount + "€\n");
                        }

                        break;

                    case 4:
                        // USCITA DAL PROGRAMMA
                        System.out.println("Arrivederci!");
                        loop = false;
                        break;

                    default:
                        System.out.println("Scelta non valida!\n");
                }

            } catch (InputMismatchException e) {
                // Gestione errore input non numerico
                System.out.println("Errore: devi inserire un valore valido!\n");
                input.nextLine(); // Pulisce buffer
            }
        }

        input.close(); // Chiude Scanner
    }
}