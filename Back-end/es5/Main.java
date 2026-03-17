package es5; // Definisce il package del programma

import java.util.*; // Importa tutte le classi del pacchetto java.util (serve per usare Scanner)

public class Main { // Classe principale del programma
    public static void main(String[] args) { // Metodo main: punto di partenza del programma

        boolean loop = true; // Variabile booleana per controllare il ciclo del menu
        int choice; // Variabile che conterrà la scelta dell'utente

        Scanner inputChoice = new Scanner(System.in); // Scanner per leggere la scelta dal menu

        // Ciclo che continua finché loop è true
        while (loop == true) {

            // Stampa del menu delle opzioni
            System.out.println("===========================");
            System.out.println("1) Positivo o negativo");
            System.out.println("2) Maggiore o minore");
            System.out.println("3) Controllo dell'età");
            System.out.println("4) Verifica dell'anno bisestile");
            System.out.println("5) Esci");
            System.out.println("===========================");

            System.out.print("\nLa mia scelta è: ");

            try {
                choice = inputChoice.nextInt(); // Lettura della scelta dell'utente

                // Struttura switch per eseguire l'operazione scelta
                switch (choice) {

                    case 1: // Controllo se un numero è positivo, negativo o zero
                        int number;
                        Scanner inputCase1 = new Scanner(System.in); // Scanner per leggere il numero
                        try { // Controllo errori input
                            System.out.println("\n===========================");
                            System.out.println("Il valore da controllare è: ");
                            System.out.println("N.B. Inserisci un numero intero\n");

                            number = inputCase1.nextInt(); // Lettura del numero inserito

                            // Controllo del segno del numero
                            if(number > 0){
                                System.out.println("Il valore da te inserito è Positivo");
                            }
                            else if (number == 0) {
                                System.out.println("Il valore da te inserito è Neutro");
                            }
                            else{
                                System.out.println("Il valore da te inserito è Negativo");
                            }

                            System.out.println("===========================\n");
                        } catch(InputMismatchException e) {
                            System.out.println("Errore: devi inserire un numero intero!\n");
                            inputCase1.nextLine(); // Pulizia buffer
                        }
                        break; // Termina il case 1

                    case 2: // Confronto tra due numeri
                        int number1, number2;
                        Scanner inputCase2 = new Scanner(System.in);
                        try {
                            System.out.println("\n===========================");
                            System.out.println("Il 1° valore è: ");
                            System.out.println("N.B. Inserisci un numero intero");

                            number1 = inputCase2.nextInt(); // Lettura del primo numero

                            System.out.println("\nIl 2° valore è: ");
                            System.out.println("N.B. Inserisci un numero intero");

                            number2 = inputCase2.nextInt(); // Lettura del secondo numero

                            // Confronto tra i due numeri
                            if(number1 > number2){
                                System.out.println(number1 + " è maggiore di " + number2);
                            }
                            else if (number1 < number2) {
                                System.out.println(number2 + " è maggiore di " + number1);
                            }
                            else{
                                System.out.println("I valori sono uguali");
                            }

                            System.out.println("===========================\n");
                        } catch(InputMismatchException e) {
                            System.out.println("Errore: devi inserire numeri interi!\n");
                            inputCase2.nextLine(); // Pulizia buffer
                        }
                        break; // Termina il case 2

                    case 3: // Controllo dell'età per accesso al sito
                        int age;
                        Scanner inputCase3 = new Scanner(System.in);
                        try {
                            System.out.println("\n===========================");
                            System.out.println("La mia età è (anni): ");
                            System.out.println("N.B. Inserisci un numero intero\n");

                            age = inputCase3.nextInt(); // Lettura dell'età

                            // Verifica se l'utente è maggiorenne
                            if(age > 18){
                                System.out.println("Puoi accedere al sito");
                            }
                            else{
                                System.out.println("Non puoi accedere al sito");
                            }

                            System.out.println("===========================\n");
                        } catch(InputMismatchException e) {
                            System.out.println("Errore: devi inserire un numero intero!\n");
                            inputCase3.nextLine(); // Pulizia buffer
                        }
                        break; // Termina il case 3

                    case 4: // Verifica se un anno è bisestile
                        int year;
                        Scanner inputCase4 = new Scanner(System.in);
                        try {
                            System.out.println("\n===========================");
                            System.out.println("Inserisci l'annata da verificare: ");
                            System.out.println("N.B. Inserisci un numero intero\n");

                            year = inputCase4.nextInt(); // Lettura dell'anno

                            // Regola per verificare se l'anno è bisestile
                            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                                System.out.println("L'anno " + year + " è bisestile");
                            } else {
                                System.out.println("L'anno " + year + " non è bisestile");
                            }

                            System.out.println("===========================\n");
                        } catch(InputMismatchException e) {
                            System.out.println("Errore: devi inserire un numero intero!\n");
                            inputCase4.nextLine(); // Pulizia buffer
                        }
                        break; // Termina il case 4

                    case 5: // Uscita dal programma
                        System.out.println("Arrivederci!");
                        loop = false; // Imposta loop a false per uscire dal ciclo
                        break;

                    default: // Caso in cui l'utente inserisce una scelta non valida
                        System.out.println("Scelta non valida, inserisci un numero da 1 a 5!\n");
                        break;
                }

            } catch(InputMismatchException e) { // Gestione errore scelta menu
                System.out.println("Errore: devi inserire un numero da 1 a 5!\n");
                inputChoice.nextLine(); // Pulizia buffer
            }
        }
    }
}