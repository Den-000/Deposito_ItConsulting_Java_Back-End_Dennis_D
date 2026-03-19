package d18M03Y2026.morning.gradeEvaluation;

import java.util.Scanner; // Importa Scanner per leggere input da tastiera

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Scanner per input utente

        int numberOfGrades; // Variabile per il numero di voti da inserire

        // Richiede il numero di voti (> 0) con controllo di validità
        do {
            System.out.print("Qanti voti vuoi aggiungere? ");
            numberOfGrades = input.nextInt(); // Legge il numero inserito
        } while (numberOfGrades <= 0); // Ripete finché il numero non è valido

        int validGradesCount = 0; // Conta quanti voti validi sono stati inseriti

        // Ciclo per inserire i voti
        for (int i = 0; i < numberOfGrades; i++) {

            System.out.print("Inserisci voto: ");
            int grade = input.nextInt(); // Legge il voto

            // Controlla se il voto è valido (tra 0 e 30)
            if (grade >= 0 && grade <= 30) {
                validGradesCount++; // Incrementa il contatore dei voti validi

                // Classificazione del voto
                if (grade >= 18 && grade < 24) {
                    System.out.println("Sufficienza"); // Voto sufficiente
                } else if (grade >= 24) {
                    System.out.println("Buono/Ottimo"); // Voto alto
                } else {
                    System.out.println("Insufficiente"); // Voto insufficiente
                }

            } else {
                // Caso voto fuori range
                System.out.println("Voto non valido");
            }
        }

        // Stampa finale del numero di voti validi inseriti
        System.out.println("Voti inseriti: " + validGradesCount);

        input.close(); // Chiude lo Scanner
    }
}