package d16M03Y2026.afternoon.additionMenuDemo;

import java.util.*; // Importa tutte le classi del package java.util (serve per usare Scanner)

public class Main { // Classe principale del programma
    public static void main(String[] args) { // Metodo main: punto di partenza del programma

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in); // Scanner per leggere input da tastiera
        int num1, num2; // Variabili per memorizzare i due numeri da sommare
        int choice; // Variabile per memorizzare la scelta dell'utente dal menu
        boolean loop = true; // Controlla se il ciclo del menu deve continuare

        // Ciclo principale che mostra il menu finché loop è true
        while (loop == true) {

            // Stampa del menu
            System.out.println("===========================");
            System.out.println("1) Addiziona");
            System.out.println("2) Esci");
            System.out.println("===========================");
            System.out.print("\nLa mia scelta è: ");

            choice = input.nextInt(); // Legge la scelta dell'utente

            // Struttura switch per gestire le varie opzioni del menu
            switch (choice) {

                case 1: // Caso 1: somma di due numeri
                    System.out.println("\n===========================");
                    System.out.print("Il 1° valore è: ");
                    num1 = input.nextInt(); // Legge il primo numero
                    System.out.print("Il 2° valore è: ");
                    num2 = input.nextInt(); // Legge il secondo numero
                    System.out.println("\nLa somma dei 2 valori è: " + (num1 + num2)); // Stampa il risultato
                    System.out.println("===========================");
                    break; // Termina il case 1

                case 2: // Caso 2: uscita dal programma
                    System.out.println("\n===========================");
                    System.out.println("Arrivederci!");
                    System.out.println("===========================");
                    loop = false; // Imposta loop a false per terminare il ciclo
                    break; // Termina il case 2

                default: // Caso in cui l'utente inserisce una scelta non valida
                    System.out.println("Scelta non valida"); 
                    break;
            }
        }
    }
}