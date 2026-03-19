package d19M03Y2026.afternoon.variousExercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // ===== MENU =====
            System.out.println("\n=== MENU ESERCIZI ===");
            System.out.println("1. Somma di due numeri (int)");
            System.out.println("2. Moltiplicazione (overloading)");
            System.out.println("3. Somma ricorsiva dei primi n numeri naturali");
            System.out.println("4. Passaggio per valore e riferimento");
            System.out.println("0. Esci");
            System.out.println("=====================\n");
            System.out.print("Scegli un'opzione: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Inserisci primo numero: ");
                    int a = scanner.nextInt();
                    System.out.print("Inserisci secondo numero: ");
                    int b = scanner.nextInt();
                    System.out.println("Somma: " + sum(a, b));
                    break;
                case 2:
                    System.out.println("1. Moltiplicazione int");
                    System.out.println("2. Moltiplicazione double");
                    int subChoice = scanner.nextInt();
                    if (subChoice == 1) {
                        System.out.print("Inserisci primo numero int: ");
                        int x = scanner.nextInt();
                        System.out.print("Inserisci secondo numero int: ");
                        int y = scanner.nextInt();
                        System.out.println("Risultato: " + multiply(x, y));
                    } else if (subChoice == 2) {
                        System.out.print("Inserisci primo numero double: ");
                        double d1 = scanner.nextDouble();
                        System.out.print("Inserisci secondo numero double: ");
                        double d2 = scanner.nextDouble();
                        System.out.print("Inserisci terzo numero double: ");
                        double d3 = scanner.nextDouble();
                        System.out.println("Risultato: " + multiply(d1, d2, d3));
                    } else {
                        System.out.println("Opzione non valida");
                    }
                    break;
                case 3:
                    System.out.print("Inserisci n: ");
                    int n = scanner.nextInt();
                    System.out.println("Somma ricorsiva: " + sumNaturals(n));
                    break;
                case 4:
                    // int primitiveValue = 10;
                    // int[] arrayValue = {10};

                    // System.out.println("Prima (primitivo): " + primitiveValue);
                    // modifyPrimitive(primitiveValue);
                    // System.out.println("Dopo (primitivo): " + primitiveValue);

                    // System.out.println("Prima (array): " + arrayValue[0]);
                    // modifyArray(arrayValue);
                    // System.out.println("Dopo (array): " + arrayValue[0]);

                    int primitiveValueInt;
                    double primitiveValueDouble;
                    
                    ArrayList<Number> arrayInput = new ArrayList<Number>();
                    ArrayList<Integer> integers = new ArrayList<Integer>();
                    ArrayList<Double> doubles = new ArrayList<Double>();

                    boolean addAnotherValue = true;
                    boolean successfullyConverted = false;
                    int numberOfIterations = 0;

                    while (addAnotherValue) {
                        @SuppressWarnings("resource")
                        Scanner tempScanner = new Scanner(System.in);
                        // System.out.println(numberOfIterations);
                        System.out.print("Inserisci n: ");
                        String primitiveValueString = tempScanner.nextLine();

                        if (successfullyConverted == false) {
                            try {
                                primitiveValueInt = Integer.parseInt(primitiveValueString);
                                successfullyConverted = true;
                                numberOfIterations++;
                                arrayInput.add(primitiveValueInt);
                            } catch (NumberFormatException e) {
                                System.err.print("");
                            }
                        }

                        if (successfullyConverted == false) {
                            try {
                                primitiveValueDouble = Double.parseDouble(primitiveValueString);
                                successfullyConverted = true;
                                numberOfIterations++;
                                arrayInput.add(primitiveValueDouble);
                            } catch (NumberFormatException e) {
                                System.err.print("");
                            }
                        }
                        
                        if (successfullyConverted == false) {
                            System.out.println("\nErrore! Inserisci un numero valido.");
                        }

                        if(numberOfIterations >= 2 && successfullyConverted){
                            System.out.println("Vuoi aggiungere un'altro numero?\n(s/n)");
                            if (tempScanner.nextLine().equals("n")) {
                                addAnotherValue = false;
                            }
                        }

                        successfullyConverted = false;
                    }

                    for(Number number : arrayInput){
                        if(number instanceof Integer){
                            integers.add((int) number);
                        } else {
                            doubles.add((double) number);
                        }
                    }

                    System.out.println("Hai inserito " + integers.size() + " numeri interi e " + doubles.size() + " numeri decimali.\n\nOvvero: ");

                    for(int number : integers){
                        System.out.println(number);
                    }

                    System.out.println("\nE:");
                    for(double number : doubles){
                        System.out.println(number);
                    }
                    break;
                case 0:
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // ===== METODI =====
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b, double c) {
        return a * b * c;
    }

    public static int sumNaturals(int n) {
        if (n == 1){
            return 1;
        } 
        return n + sumNaturals(n - 1);
    }

    // ?? Non mi è chiaro il concetto di "modifica una variabile primitiva", come dovrei modificarla? Quale dovrebbe essere la modifica da apportare??
    // * Mancano controlli/validazioni nel codice e commenti vari*
    public static void modifyPrimitive(int x) {
        x += 10;
        System.out.println("Dentro il metodo (primitivo): " + x);
    }

    public static void modifyArray(int[] arr) {
        arr[0] += 10;
        System.out.println("Dentro il metodo (array): " + arr[0]);
    }
}