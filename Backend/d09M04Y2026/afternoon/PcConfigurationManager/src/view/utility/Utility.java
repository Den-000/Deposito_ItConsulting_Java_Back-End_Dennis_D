package view.utility;

import java.util.Scanner;

public class Utility {

    // Istanza unica (Singleton)
    private static Utility instance;

    // Scanner condiviso (una sola volta!)
    private Scanner scanner;

    // Costruttore privato
    private Utility() {
        scanner = new Scanner(System.in);
    }

    // Metodo per ottenere l'istanza
    public static Utility getInstance() {
        if (instance == null) {
            instance = new Utility();
        }
        return instance;
    }

    // Chiede un input integer e verifica validità
    public int askInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero intero valido.");
            }
        }
    }

    // Chiede un input double e verifica validità
    public double askDouble() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero decimale valido.");
            }
        }
    }

    // Chiede un input float e verifica validità
    public float askFloat() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero decimale valido.");
            }
        }
    }

    // Chiede un input boolean
    public boolean askBoolean() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("true") || input.equals("t") || input.equals("si") || input.equals("s") || input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("false") || input.equals("f") || input.equals("no") || input.equals("n")) {
                return false;
            } else {
                System.out.println("Errore: inserisci true/false oppure s/n.");
            }
        }
    }

    // Chiede una stringa
    public String askString() {
        return scanner.nextLine();
    }
}