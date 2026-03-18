package d18M3Y2026.afternoon.orderBakery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX_ITEMS = 10;
        String[] dessertNames = new String[MAX_ITEMS];
        int[] quantities = new int[MAX_ITEMS];

        int itemCount;

        // Chiedi quanti dolci diversi vuole ordinare
        do {
            System.out.print("Quanti dolci diversi vuoi ordinare? (max 10): ");
            itemCount = scanner.nextInt();
        } while (itemCount < 1 || itemCount > MAX_ITEMS);

        scanner.nextLine(); // pulizia buffer

        // Inserimento dati
        for (int i = 0; i < itemCount; i++) {
            System.out.print("\nInserisci il nome del dolce n." + (i + 1) + ": ");
            dessertNames[i] = scanner.nextLine();

            int quantity;

            // Controllo quantità (no numeri negativi)
            do {
                System.out.print("\nInserisci la quantità per → " + dessertNames[i] + ": ");
                quantity = scanner.nextInt();

                if (quantity <= 0) {
                    System.out.println("\nErrore: la quantità non può essere negativa. Riprova.");
                }
            } while (quantity <= 0);

            quantities[i] = quantity;
            scanner.nextLine(); // pulizia buffer
        }

        // Stampa elenco ordini
        System.out.println("\n=== Elenco ordini ===");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(dessertNames[i] + " - Quantità: " + quantities[i]);
        }

        // Calcolo totale
        int totalQuantity = 0;
        for (int i = 0; i < itemCount; i++) {
            totalQuantity += quantities[i];
        }

        System.out.println("\nQuantità totale di dolci ordinati: " + totalQuantity);

        scanner.close();
    }
}