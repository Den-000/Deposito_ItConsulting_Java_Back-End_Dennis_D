package accountManagementDemo_doWhile; // Package del programma

import java.util.ArrayList; // Per gestire una lista dinamica di account
import java.util.InputMismatchException; // Per gestire errori di input (es. lettere invece di numeri)
import java.util.Scanner; // Per leggere input da tastiera

public class Main {

    public static void main(String[] args) {

        ArrayList<Account> accountsList = new ArrayList<>(); // Lista di tutti gli account registrati
        Account tempAccount = null; // Riferimento all'account attualmente loggato

        boolean loop = true; // Controlla il ciclo principale (menu iniziale)
        int choice; // Scelta dell'utente nel menu principale

        Scanner input = new Scanner(System.in); // Scanner per input utente

        boolean internalLoop = true; // Controlla il menu dopo il login
        int internalChoice; // Scelta nel menu interno

        boolean subInternalLoop; // Controlla il sotto-menu di modifica account
        int subInternalChoice; // Scelta nel sotto-menu

        String username, email, password; // Dati dell'utente

        // CICLO PRINCIPALE (menu iniziale)
        do {

            System.out.println("===========================");
            System.out.println("1) Login");
            System.out.println("2) Registrati");
            System.out.println("3) Esci");
            System.out.println("===========================");

            System.out.print("\nLa mia scelta è: ");

            try {
                choice = input.nextInt(); // Legge la scelta numerica
                input.nextLine(); // Pulisce il buffer

                switch (choice) {

                    case 1: // LOGIN

                        tempAccount = null; // Reset account temporaneo
                        boolean accountFound = false; // Flag per verificare se l'account esiste

                        // Chiedi email in input
                        System.out.print("Email: ");
                        email = input.nextLine();

                        // Ricerca account nella lista tramite email
                        for (Account account : accountsList) {
                            if (account.getEmail().equals(email)) {
                                tempAccount = account; // Salva riferimento
                                accountFound = true; // Imposta flag a true
                                break;
                            }
                        }

                        if (accountFound) {

                            int passwordTry = 0; // Contatore tentativi password

                            // Ciclo per inserimento password (max 3 tentativi)
                            do {
                                // Chiedi password in input
                                System.out.print("Password: ");
                                password = input.nextLine();

                                // Se la password è errata
                                if (!password.equals(tempAccount.getPassword())) {

                                    if (passwordTry > 1) { // Dopo 3 tentativi falliti
                                        System.out.println("Troppi tentativi errati!\n");
                                        passwordTry = 3;
                                        internalLoop = false;
                                    } else { // Prima dei 3 tentativi falliti
                                        passwordTry++; // Incrementa contatore tentativi falliti
                                        System.out.println("Password errata!\n");
                                    }

                                } 
                                // Password corretta
                                else {
                                    System.out.println("Login effettuato con successo!\n");

                                    internalLoop = true; // Attiva menu interno

                                    // MENU DOPO LOGIN
                                    do {
                                        System.out.println("===========================");
                                        System.out.println("1) Visualizza dati account");
                                        System.out.println("2) Modifica account");
                                        System.out.println("3) Elimina account");
                                        System.out.println("4) Logout");
                                        System.out.println("===========================");

                                        System.out.print("\nLa mia scelta è: ");

                                        try {
                                            internalChoice = input.nextInt(); // Legge la scelta numerica
                                            input.nextLine();

                                            switch (internalChoice) {

                                                case 1: // VISUALIZZA DATI ACCOUNT (Richiamo ai metodi dell'oggetto)
                                                    System.out.println("\n===== DATI ACCOUNT =====");
                                                    System.out.println("Username: " + tempAccount.getUsername());
                                                    System.out.println("Email: " + tempAccount.getEmail());
                                                    System.out.println("Password: " + tempAccount.getPassword());
                                                    System.out.println("========================\n");
                                                    break;

                                                case 2: // MODIFICA ACCOUNT

                                                    subInternalLoop = true;

                                                    // SOTTO-MENU MODIFICA
                                                    do {
                                                        System.out.println("===========================");
                                                        System.out.println("Cosa vuoi modificare?");
                                                        System.out.println("1) Username");
                                                        System.out.println("2) Email");
                                                        System.out.println("3) Password");
                                                        System.out.println("4) Torna indietro");
                                                        System.out.println("===========================");

                                                        System.out.print("\nLa mia scelta è: ");

                                                        try {
                                                            subInternalChoice = input.nextInt(); // Legge la scelta numerica
                                                            input.nextLine();

                                                            switch (subInternalChoice) {

                                                                case 1: // Modifica username (Richiamo al metodo dell'oggetto)
                                                                    System.out.println("Username attuale: " + tempAccount.getUsername());
                                                                    System.out.print("Nuovo username: ");
                                                                    tempAccount.setUsername(input.nextLine());
                                                                    System.out.println("Username aggiornato!\n");
                                                                    break;

                                                                case 2: // Modifica email (Richiamo al metodo dell'oggetto)
                                                                    System.out.println("Email attuale: " + tempAccount.getEmail());
                                                                    System.out.print("Nuova email: ");
                                                                    tempAccount.setEmail(input.nextLine());
                                                                    System.out.println("Email aggiornata!\n");
                                                                    break;

                                                                case 3: // Modifica password (Richiamo al metodo dell'oggetto)
                                                                    System.out.print("Nuova password: ");
                                                                    tempAccount.setPassword(input.nextLine());
                                                                    System.out.println("Password aggiornata!\n");
                                                                    break;

                                                                case 4: // Conferma uscita dal sotto-menu
                                                                    String exit; // Variabile del ciclo sottostante
                                                                    do { // Ciclo di conferma e validazione
                                                                        System.out.println("Vuoi tornare al menu precedente?");
                                                                        System.out.println("(s = sì, n = no)");
                                                                        exit = input.nextLine();
                                                                        if (exit.equals("s")) {
                                                                            subInternalLoop = false;
                                                                        }
                                                                    } while (!exit.equals("s") && !exit.equals("n"));
                                                                    break;

                                                                default:
                                                                    System.out.println("Scelta non valida!\n");
                                                            }

                                                        } catch (InputMismatchException e) {
                                                            System.out.println("Errore: devi inserire un numero!\n");
                                                            input.nextLine();
                                                        }

                                                    } while (subInternalLoop);
                                                    break;

                                                case 3: // ELIMINA ACCOUNT

                                                    String remove; // Variabile del ciclo sottostante
                                                    do { // Ciclo di conferma e validazione
                                                        System.out.println("Sei sicuro di voler eliminare l'account?");
                                                        System.out.println("(s = sì, n = no)");
                                                        remove = input.nextLine();

                                                        if (remove.equals("s")) {
                                                            accountsList.remove(tempAccount);
                                                            System.out.println("Account eliminato!\n");
                                                            tempAccount = null;
                                                            passwordTry = 3;
                                                            internalLoop = false;
                                                        }

                                                    } while (!remove.equals("s") && !remove.equals("n"));
                                                    break;

                                                case 4: // LOGOUT

                                                    String exit; // Variabile del ciclo sottostante
                                                    do { // Ciclo di conferma e validazione
                                                        System.out.println("Vuoi effettuare il logout?");
                                                        System.out.println("(s = sì, n = no)");
                                                        exit = input.nextLine();

                                                        if (exit.equals("s")) { // Logout
                                                            System.out.println("Logout effettuato!\n");
                                                            tempAccount = null;
                                                            internalLoop = false;
                                                            passwordTry = 3;
                                                        }

                                                    } while (!exit.equals("s") && !exit.equals("n"));
                                                    break;

                                                default:
                                                    System.out.println("Scelta non valida!\n");
                                            }

                                        } catch (InputMismatchException e) {
                                            System.out.println("Errore: devi inserire un numero!\n");
                                            input.nextLine();
                                        }

                                    } while (internalLoop);
                                }

                            } while (passwordTry < 3 && internalLoop);

                        } else {
                            System.out.println("Account non trovato!\n");
                        }

                        break;

                    case 2: // REGISTRAZIONE

                        // Chiedi dati in input
                        System.out.print("Inserisci username: ");
                        username = input.nextLine();

                        System.out.print("Inserisci email: ");
                        email = input.nextLine();

                        // Verifica se l'email è già presente
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

                        accountsList.add(new Account(username, email, password)); // Creazione account ed aggiunta all'array

                        System.out.println("Registrazione completata!\n");
                        break;

                    case 3: // USCITA

                        String exit; // Variabile del ciclo sottostante
                        do { // Ciclo di conferma e validazione
                            System.out.println("Vuoi uscire dall'app?");
                            System.out.println("(s = sì, n = no)");
                            exit = input.nextLine();

                            if (exit.equals("s")) { // Chiudi loop/app
                                loop = false;
                                System.out.println("Arrivederci!");
                            }

                        } while (!exit.equals("s") && !exit.equals("n"));
                        break;

                    default:
                        System.out.println("Scelta non valida!\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Errore: devi inserire un numero!\n");
                input.nextLine();
            }

        } while (loop);

        input.close(); // Chiusura Scanner
    }
}