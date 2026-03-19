package d19M03Y2026.afternoon.calculator; // Dhichiarazione package

import java.util.ArrayList; // Per gestire una lista dinamica di numeri
import java.util.Scanner; // Per input da tastiera

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Scanner per leggere input

        double num1; // Primo numero
        double num2; // Secondo  numero

        int choice; // Scelta dell'utente

        // CICLO PRINCIPALE (menu)
        do {

            // Stampa menu
            System.out.println("\n=== MENU ===");
            System.out.println("1) Somma");
            System.out.println("2) Sottrazione");
            System.out.println("3) Moltiplicazione");
            System.out.println("4) Divisione");
            System.out.println("5) Potenza");
            System.out.println("6) Somma tra più numeri");
            System.out.println("7) Esci");
            System.out.println("============\n");

            System.out.print("Scelta: ");
            choice = scanner.nextInt(); // Legge scelta
            scanner.nextLine(); // Pulisce buffer

            switch (choice) {

                case 1: // SOMMA
                    System.out.print("Inserisci il primo numero: ");
                    num1 = scanner.nextDouble();

                    System.out.print("Inserisci il secondo numero: ");
                    num2 = scanner.nextDouble();

                    // Chiama metodo add
                    System.out.println("Risultato: " + add(num1, num2));
                    break;

                case 2: // SOTTRAZIONE
                    System.out.print("Inserisci il primo numero: ");
                    num1 = scanner.nextDouble();

                    System.out.print("Inserisci il secondo numero: ");
                    num2 = scanner.nextDouble();

                    // Chiama metodo subtract
                    System.out.println("Risultato: " + subtract(num1, num2));
                    break;

                case 3: // MOLTIPLICAZIONE
                    System.out.print("Inserisci il primo numero: ");
                    num1 = scanner.nextDouble();

                    System.out.print("Inserisci il secondo numero: ");
                    num2 = scanner.nextDouble();

                    // Chiama metodo multiply
                    System.out.println("Risultato: " + multiply(num1, num2));
                    break;

                case 4: // DIVISIONE
                    System.out.print("Inserisci il primo numero: ");
                    num1 = scanner.nextDouble();

                    System.out.print("Inserisci il secondo numero: ");
                    num2 = scanner.nextDouble();

                    // Chiama metodo divide
                    System.out.println("Risultato: " + divide(num1, num2));
                    break;

                case 5: // POTENZA
                    System.out.print("Inserisci la base: ");
                    num1 = scanner.nextDouble();

                    System.out.print("Inserisci l'esponente: ");
                    num2 = scanner.nextDouble();

                    // Chiama metodo power
                    System.out.println("Risultato: " + power(num1, num2));
                    break;

                case 6: // SOMMA MULTIPLA
                    // System.out.print("Quanti numeri vuoi sommare? ");
                    // int n = scanner.nextInt();

                    // double sum = 0;

                    // for (int i = 1; i <= n; i++) {
                    //     System.out.print("Inserisci numero " + i + ": ");
                    //     double num = scanner.nextDouble();
                    //     sum += num;
                    // }

                    // System.out.println("Risultato: " + sum);

                    //  scanner.nextLine(); // pulisce buffer

                    ArrayList<Double> numbers = new ArrayList<>(); // Lista per salvare i numeri

                    System.out.println("Inserisci numeri (digita '=' per calcolare):");

                    // Input dinamico finché l'utente non scrive "="
                    while (true) {
                        System.out.print("> ");
                        String input = scanner.nextLine();

                        if (input.equals("=")) {
                            break; // Esce dal ciclo
                        }

                        try {
                            double num = Double.parseDouble(input); // Converte stringa in numero
                            numbers.add(num); // Aggiunge alla lista
                        } catch (NumberFormatException e) {
                            System.out.println("Input non valido, riprova.");
                        }
                    }

                    // Calcolo somma della lista con chiamata a funzione sumList
                    double result = sumList(numbers);
                    System.out.println("Risultato: " + result);

                    break;

                case 7: // USCITA
                    System.out.println("Uscita dal programma...");
                    break;

                default: // Scelta non valida
                    System.out.println("Scelta non valida");
            }

        } while (choice != 7); // Continua finché l'utente non sceglie di uscire

        scanner.close(); // Chiude lo Scanner
    }

    // ===== METODI =====

    // Somma di due numeri
    public static double add(double a, double b) {
        return a + b;
    }

    // Sottrazione
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Moltiplicazione
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Divisione (con controllo divisione per zero)
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Errore: divisione per zero");
            return 0;
        }
        return a / b;
    }

    // Potenza (usa Math.pow)
    public static double power(double base, double exp) {
        return Math.pow(base, exp);
    }

    // Somma tutti i numeri presenti in una lista
    public static double sumList(ArrayList<Double> list) {
        double sum = 0;
    
        // Ciclo foreach per sommare tutti gli elementi
        for (double n : list) {
            sum += n;
        }
    
        return sum;
    }
}