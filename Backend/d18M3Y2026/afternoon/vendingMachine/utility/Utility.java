package d18M3Y2026.afternoon.vendingMachine.utility;

import java.util.Scanner;

public class Utility {
    
    // Chiede un input integer e verifica validità
    @SuppressWarnings("resource")
    public static int askInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.nextLine();
                int value = Integer.parseInt(input); // Converte stringa in int
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero intero valido.");
            }
        }
    }

    // Chiede un input double e verifica validità
    @SuppressWarnings("resource")
    public static double askDouble() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.nextLine();
                double value = Double.parseDouble(input); // Converte stringa in double
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero decimale valido.");
            }
        }
    }

    // Chiede un input stringa (nessun controllo sul tipo)
    @SuppressWarnings("resource")
    public static String askString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}