package d18M03Y2026.afternoon.vendingMachine.utility;

import java.util.Scanner;

public class Utility {
    
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
                System.out.println("Errore: inserisci un numero intero valido.");
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
                System.out.println("Errore: inserisci un numero decimale valido.");
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