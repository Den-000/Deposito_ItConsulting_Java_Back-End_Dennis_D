package es6; // Definisce il package del programma

import java.util.ArrayList; // Importa ArrayList per gestire una lista dinamica di account
import java.util.InputMismatchException; // Importa l'eccezione per errori di input
import java.util.Scanner; // Importa Scanner per leggere input da tastiera

public class Main {

    public static void main(String[] args) {

        ArrayList<Account> accountsList = new ArrayList<>(); // Lista che contiene tutti gli account registrati
        Account tempAccount = null; // Variabile temporanea per memorizzare l'account loggato

        boolean loop = true; // Controlla il ciclo principale del programma
        int choice; // Scelta del menu principale

        Scanner input = new Scanner(System.in); // Scanner per input utente

        boolean internalLoop; // Ciclo interno (dopo login)
        int internalChoice; // Scelta nel menu interno

        boolean subInternalLoop; // Sotto-menu modifica account
        int subInternalChoice; // Scelta nel sotto-menu

        String username, email, password; // Variabili per dati utente

        // CICLO PRINCIPALE
        while (loop) {

            // Menu principale
            System.out.println("===========================");
            System.out.println("1) Login");
            System.out.println("2) Registrati");
            System.out.println("3) Esci");
            System.out.println("===========================");

            System.out.print("\nLa mia scelta è: ");

            try {
                choice = input.nextInt(); // Legge scelta numerica
                input.nextLine(); // Pulisce il buffer

                switch (choice) {

                    case 1: // LOGIN

                        tempAccount = null; // Reset account temporaneo
                        boolean accountFound = false; // Flag per verificare se esiste

                        System.out.print("Email: ");
                        email = input.nextLine();

                        // Ricerca account nella lista
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

                            // Controllo password
                            if (password.equals(tempAccount.getPassword())) {

                                System.out.println("Login effettuato con successo!\n");

                                internalLoop = true;

                                // MENU DOPO LOGIN
                                while (internalLoop) {

                                    System.out.println("===========================");
                                    System.out.println("1) Modifica account");
                                    System.out.println("2) Elimina account");
                                    System.out.println("3) Logout");
                                    System.out.println("===========================");

                                    System.out.print("\nLa mia scelta è: ");

                                    try {
                                        internalChoice = input.nextInt();
                                        input.nextLine();

                                        switch (internalChoice) {

                                            case 1: // MODIFICA ACCOUNT

                                                subInternalLoop = true;

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
                                                            case 1:
                                                                // Modifica username
                                                                System.out.println("Username attuale: " + tempAccount.getUsername());
                                                                System.out.print("Nuovo username: ");
                                                                tempAccount.setUsername(input.nextLine());
                                                                System.out.println("Username aggiornato!\n");
                                                                break;

                                                            case 2:
                                                                // Modifica email
                                                                System.out.println("Email attuale: " + tempAccount.getEmail());
                                                                System.out.print("Nuova email: ");
                                                                tempAccount.setEmail(input.nextLine());
                                                                System.out.println("Email aggiornata!\n");
                                                                break;

                                                            case 3:
                                                                // Modifica password
                                                                System.out.print("Nuova password: ");
                                                                tempAccount.setPassword(input.nextLine());
                                                                System.out.println("Password aggiornata!\n");
                                                                break;

                                                            case 4:
                                                                // Torna al menu precedente
                                                                subInternalLoop = false;
                                                                break;

                                                            default:
                                                                System.out.println("Scelta non valida!\n");
                                                        }

                                                    } catch (InputMismatchException e) {
                                                        // Errore se input non numerico
                                                        System.out.println("Errore: devi inserire un numero!\n");
                                                        input.nextLine();
                                                    }
                                                }
                                                break;

                                            case 2: // ELIMINA ACCOUNT
                                                accountsList.remove(tempAccount); // Rimuove account dalla lista
                                                System.out.println("Account eliminato!\n");
                                                tempAccount = null;
                                                internalLoop = false; // Esce dal menu interno
                                                break;

                                            case 3: // LOGOUT
                                                System.out.println("Logout effettuato!\n");
                                                tempAccount = null;
                                                internalLoop = false;
                                                break;

                                            default:
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

                        // Controllo se email già esiste
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
                        loop = false;
                        break;

                    default:
                        System.out.println("Scelta non valida!\n");
                }

            } catch (InputMismatchException e) {
                // Gestione errore input non numerico
                System.out.println("Errore: devi inserire un numero!\n");
                input.nextLine();
            }
        }

        input.close(); // Chiude lo Scanner
    }
}