package d18M03Y2026.afternoon.simplifiedBacomat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean loop = true; // Controlla il ciclo principale del programma
        int choice; // Scelta dell'utente nel menu
        int amountAvaible = 0; // Saldo disponibile (inizialmente 0)

        // CICLO PRINCIPALE (menu)
        do {
            // Stampa menu operazioni
            System.out.println("========== MENU ==========");
            System.out.println("1) Visualizza saldo");
            System.out.println("2) Preleva");
            System.out.println("3) Deposita");
            System.out.println("4) Esci");
            System.out.println("==========================");

            choice = askInt(); // Input sicuro (gestito dal metodo)

            // Gestione scelta utente
            switch (choice) {

                case 1: // VISUALIZZA SALDO
                    System.out.println("\nIl saldo attuale ammonta a: " + amountAvaible + "€\n");
                    break;

                case 2: // PRELIEVO
                    System.out.println("\nQuanto vuoi prelevare?");
                    System.out.println("(n.b. Solo numeri interi)");

                    // Chiama il metodo withdraw e aggiorna il saldo
                    amountAvaible = withdraw(askInt(), amountAvaible);
                    break;

                case 3: // DEPOSITO
                    System.out.println("\nQuanto vuoi depositare?");
                    System.out.println("(n.b. Solo numeri interi)");

                    // Chiama il metodo deposit e aggiorna il saldo
                    amountAvaible = deposit(askInt(), amountAvaible);
                    break;

                case 4: // USCITA
                    loop = false;
                    System.out.println("Arrivederci!");
                    break;

                default: // Scelta non valida
                    System.out.println("Scelta non valida\n");
            }

        } while (loop); // Continua finché loop è true
    }


    // Metodo per prelevare denaro
    public static int withdraw(int amountToWithdraw, int amountAvaible){

        // Controlla se il saldo è sufficiente
        if (amountAvaible >= amountToWithdraw) {
            amountAvaible -= amountToWithdraw; // Sottrae l'importo dal saldo

            System.out.println("\nIl nuovo saldo ammonta a: " + amountAvaible + "€\n");
        } else {
            System.out.println("Cifra non valida!\n"); // Saldo insufficiente
        }

        return amountAvaible; // Restituisce il saldo aggiornato
    }

    // Metodo per depositare denaro
    public static int deposit(int amountToDeposit, int amountAvaible){

        // Controlla che l'importo sia valido (> 0)
        if (amountToDeposit > 0) {
            amountAvaible += amountToDeposit; // Aggiunge l'importo al saldo

            System.out.println("\nIl nuovo saldo ammonta a: " + amountAvaible + "€\n");
        } else {
            System.out.println("Cifra non valida!\n"); // Importo non valido
        }

        return amountAvaible; // Restituisce il saldo aggiornato
    }


    // Metodo per leggere un intero con controllo errori
    @SuppressWarnings("resource")
    public static int askInt() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String input = scanner.nextLine(); // Legge input come stringa
                int value = Integer.parseInt(input); // Converte in intero
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero intero valido.\n");
            }
        }
    }

    // Metodo per leggere un double con controllo errori
    @SuppressWarnings("resource")
    public static double askDouble() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String input = scanner.nextLine();
                double value = Double.parseDouble(input); // Converte in double
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero decimale valido.\n");
            }
        }
    }

    // Metodo per leggere una stringa (senza controlli)
    @SuppressWarnings("resource")
    public static String askString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}