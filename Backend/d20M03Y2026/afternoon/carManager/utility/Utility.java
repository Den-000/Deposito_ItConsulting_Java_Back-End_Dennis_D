package d20M03Y2026.afternoon.carManager.utility;

import java.util.Scanner;

// Classe Utility: raccoglie metodi statici per leggere input in modo sicuro
public class Utility {

    // Scanner privato condiviso per leggere da tastiera
    private static Scanner scanner = new Scanner(System.in);

    // ======================
    // METODI BASE PER INPUT
    // ======================

    // Legge un numero intero senza far crashare il programma
    public static int askInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine()); // Converte input in int
            } catch (NumberFormatException e) {              // Gestisce input non valido
                System.err.println("Numero non valido, riprova.");
            }
        }
    }

    // Legge un numero double senza far crashare il programma
    public static double askDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine()); // Converte input in double
            } catch (NumberFormatException e) {               // Gestisce input non valido
                System.err.println("Numero non valido, riprova.");
            }
        }
    }

    // Legge una stringa dall’utente
    public static String askString() {
        return scanner.nextLine();
    }

    // ======================
    // METODI CON MESSAGGIO E RANGE
    // ======================

    // Legge un intero con messaggio e controllo del range (min-max)
    public static int askInt(String msg, int min, int max) {
        int n;
        while (true) {
            System.out.print(msg);
            try {
                n = Integer.parseInt(scanner.nextLine());  // Converte input
                if (n >= min && n <= max) {               // Controlla che sia nel range
                    return n;
                } else {
                    System.out.println("Numero fuori range (" + min + "-" + max + "), riprova.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Numero non valido, riprova.");
            }
        }
    }

    // Legge un double con messaggio e controllo del range (min-max)
    public static double askDouble(String msg, double min, double max) {
        double n;
        while (true) {
            System.out.print(msg);
            try {
                n = Double.parseDouble(scanner.nextLine()); // Converte input
                if (n >= min && n <= max) {                 // Controlla range
                    return n;
                } else {
                    System.out.println("Numero fuori range (" + min + " - " + max + "), riprova.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Numero non valido, riprova.");
            }
        }
    }

    // Legge una stringa con messaggio, obbligatoria e non vuota
    public static String askString(String msg) {
        String input;
        while (true) {
            System.out.print(msg);
            input = scanner.nextLine().trim();   // Rimuove spazi vuoti
            if (!input.isEmpty()) {              // Controlla che non sia vuota
                return input;
            }
            System.out.println("Input non può essere vuoto, riprova.");
        }
    }

}