package accountManagementDemo; // Definisce il package del programma

import java.util.ArrayList; // Importa ArrayList per gestire una lista dinamica di account
import java.util.InputMismatchException; // Importa l'eccezione per gestire input non validi
import java.util.Scanner; // Importa Scanner per leggere input da tastiera

public class Main {

    public static void main(String[] args) {

        ArrayList<Account> accountsList = new ArrayList<>(); // Lista che conterrà tutti gli account registrati
        Account tempAccount = null; // Variabile temporanea per memorizzare l'account loggato

        boolean loop = true; // Controlla il ciclo principale del programma
        int choice; // Variabile per memorizzare la scelta del menu principale

        Scanner input = new Scanner(System.in); // Scanner per leggere input utente

        boolean internalLoop; // Controlla il ciclo interno (menu dopo login)
        int internalChoice; // Scelta del menu interno

        boolean subInternalLoop; // Controlla il sotto-menu per modifiche account
        int subInternalChoice; // Scelta del sotto-menu

        String username, email, password; // Variabili per memorizzare dati utente

        // CICLO PRINCIPALE
        while (loop) {

            // Stampa del menu principale
            System.out.println("===========================");
            System.out.println("1) Login");
            System.out.println("2) Registrati");
            System.out.println("3) Esci");
            System.out.println("===========================");

            System.out.print("\nLa mia scelta è: ");

            try {
                choice = input.nextInt(); // Legge scelta numerica da tastiera
                input.nextLine(); // Pulisce il buffer dello Scanner

                switch (choice) {

                    case 1: // LOGIN
                        tempAccount = null; // Resetta l'account temporaneo
                        boolean accountFound = false; // Flag per verificare se l'account esiste

                        System.out.print("Email: ");
                        email = input.nextLine();

                        // Ricerca dell'account nella lista
                        for (Account account : accountsList) {
                            if (account.getEmail().equals(email)) {
                                tempAccount = account; // Salva account trovato
                                accountFound = true;
                                break;
                            }
                        }

                        if (accountFound) {
                            System.out.print("Password: ");
                            password = input.nextLine();

                            // Controlla se la password inserita è corretta
                            if (password.equals(tempAccount.getPassword())) {
                                System.out.println("Login effettuato con successo!\n");

                                internalLoop = true; // Avvia ciclo del menu interno

                                // MENU DOPO LOGIN
                                while (internalLoop) {
                                    System.out.println("===========================");
                                    System.out.println("1) Visualizza dati account");
                                    System.out.println("2) Modifica account");
                                    System.out.println("3) Elimina account");
                                    System.out.println("4) Logout");
                                    System.out.println("===========================");

                                    System.out.print("\nLa mia scelta è: ");

                                    try {
                                        internalChoice = input.nextInt();
                                        input.nextLine(); // Pulisce buffer

                                        switch (internalChoice) {
                                            case 1: // VISUALIZZA DATI ACCOUNT
                                                System.out.println("\n===== DATI ACCOUNT =====");
                                                System.out.println("Username: " + tempAccount.getUsername());
                                                System.out.println("Email: " + tempAccount.getEmail());
                                                System.out.println("Password: " + tempAccount.getPassword());
                                                System.out.println("========================\n");
                                                break;

                                            case 2: // MODIFICA ACCOUNT
                                                subInternalLoop = true; // Avvia sotto-menu modifica

                                                // SOTTO-MENU MODIFICA
                                                while (subInternalLoop) {
                                                    System.out.println("===========================");
                                                    System.out.println("Cosa vuoi modificare?");
                                                    System.out.println("1) Username");
                                                    System.out.println("2) Email");
                                                    System.out.println("3) Password");
                                                    System.out.println("4) Torna indietro");
                                                    System.out.println("===========================");

                                                    System.out.print("\nLa mia scelta è: ");

                                                    try {
                                                        subInternalChoice = input.nextInt();
                                                        input.nextLine();

                                                        switch (subInternalChoice) {
                                                            case 1: // Modifica username
                                                                System.out.println("Username attuale: " + tempAccount.getUsername());
                                                                System.out.print("Nuovo username: ");
                                                                tempAccount.setUsername(input.nextLine());
                                                                System.out.println("Username aggiornato!\n");
                                                                break;

                                                            case 2: // Modifica email
                                                                System.out.println("Email attuale: " + tempAccount.getEmail());
                                                                System.out.print("Nuova email: ");
                                                                tempAccount.setEmail(input.nextLine());
                                                                System.out.println("Email aggiornata!\n");
                                                                break;

                                                            case 3: // Modifica password
                                                                System.out.print("Nuova password: ");
                                                                tempAccount.setPassword(input.nextLine());
                                                                System.out.println("Password aggiornata!\n");
                                                                break;

                                                            case 4: // Torna al menu precedente
                                                                subInternalLoop = false;
                                                                break;

                                                            default: // Scelta non valida
                                                                System.out.println("Scelta non valida!\n");
                                                        }

                                                    } catch (InputMismatchException e) {
                                                        // Gestione errore input non numerico
                                                        System.out.println("Errore: devi inserire un numero!\n");
                                                        input.nextLine(); // Pulisce buffer
                                                    }
                                                }
                                                break;

                                            case 3: // ELIMINA ACCOUNT
                                                accountsList.remove(tempAccount); // Rimuove account dalla lista
                                                System.out.println("Account eliminato!\n");
                                                tempAccount = null;
                                                internalLoop = false; // Esce dal menu interno
                                                break;

                                            case 4: // LOGOUT
                                                System.out.println("Logout effettuato!\n");
                                                tempAccount = null;
                                                internalLoop = false;
                                                break;

                                            default: // Scelta non valida
                                                System.out.println("Scelta non valida!\n");
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Errore: devi inserire un numero!\n");
                                        input.nextLine();
                                    }
                                }

                            } else {
                                System.out.println("Password errata!\n");
                            }

                        } else {
                            System.out.println("Account non trovato!\n");
                        }

                        break;

                    case 2: // REGISTRAZIONE
                        System.out.print("Inserisci username: ");
                        username = input.nextLine();

                        System.out.print("Inserisci email: ");
                        email = input.nextLine();

                        // Controllo se l'email è già registrata
                        boolean emailExists = false;
                        for (Account acc : accountsList) {
                            if (acc.getEmail().equals(email)) {
                                emailExists = true;
                                break;
                            }
                        }

                        if (emailExists) {
                            System.out.println("Email già registrata!\n");
                            break;
                        }

                        System.out.print("Inserisci password: ");
                        password = input.nextLine();

                        // Crea nuovo account e lo aggiunge alla lista
                        accountsList.add(new Account(username, email, password));

                        System.out.println("Registrazione completata!\n");
                        break;

                    case 3: // USCITA
                        System.out.println("Arrivederci!");
                        loop = false; // Termina ciclo principale
                        break;

                    default: // Scelta non valida
                        System.out.println("Scelta non valida!\n");
                }

            } catch (InputMismatchException e) {
                // Gestione errore input non numerico
                System.out.println("Errore: devi inserire un numero!\n");
                input.nextLine();
            }
        }

        input.close(); // Chiude Scanner
    }
}