package d19M03Y2026.afternoon.gradeManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedi all'utente quanti voti dovrà inserire
        System.out.print("Quanti voti vuoi inserire? ");
        int numGrades = scanner.nextInt();

        int[] grades = new int[numGrades];

        // Inserisci voti
        for (int i = 0; i < numGrades; i++) {
            System.out.print("nserisci voto n." + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        boolean loop = true;

        // CICLO PRINCIPALE (Menu)
        while (loop) {
            System.out.println("\n=== Menu ===");
            System.out.println("1) Calcola la media dei voti");
            System.out.println("2) Mostra voto più alto");
            System.out.println("3) Mostra voto più basso");
            System.out.println("4) Controlla promozione");
            System.out.println("5) Insegnante assegna un voto");
            System.out.println("6) Esci");
            System.out.println("============\n");
            System.out.print("Opzione: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double average = calculateAverage(grades);
                    System.out.println("La media dei voti è: " + average);
                    break;
                case 2:
                    int maxGrade = findMaxGrade(grades);
                    System.out.println("Il voto più alto è: " + maxGrade); // Mostra voto più alto
                    break;
                case 3:
                    int minGrade = findMinGrade(grades);
                    System.out.println("Il voto più basso è: " + minGrade); // Mostra voto più basso
                    break;
                case 4:
                    double avgForPass = calculateAverage(grades); // Controlla se la classe è stata promossa (in media)
                    checkPass(avgForPass);
                    break;
                case 5:
                    System.out.print("Inserisci la matricola dello studente: ");
                    int studentIndex = scanner.nextInt() - 1; // -1 perché l'array parte da 0
                    System.out.print("Inserisci il voto: ");
                    int grade = scanner.nextInt();
                    assignGrade(grades, studentIndex, grade);
                    break;
                case 6:
                    System.out.println("Uscendo...");
                    loop = false;
                    break;
                default:
                    System.out.println("Opzione non valida! Per piacere scegli un numero fra 1 e 5.");
            }
        }

        scanner.close();
    }

    // Metodo per il calcolo della media
    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    // Metodo per la ricerca del voto più alto
    public static int findMaxGrade(int[] grades) {
        int max = grades[0];
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    // Metodo per la ricerca del voto più basso
    public static int findMinGrade(int[] grades) {
        int min = grades[0];
        for (int grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

    // Metodo per controllare se lo studente è stato promosso
    public static void checkPass(double average) {
        if (average >= 6) {
            System.out.println("Promosso");
        } else {
            System.out.println("Bocciato");
        }
    }

    // Metodo per permettere all'insegnante di assegnare un voto
    public static void assignGrade(int[] grades, int studentIndex, int grade) {
        if (studentIndex >= 0 && studentIndex < grades.length) {
            grades[studentIndex] = grade;
            System.out.println("Voto assegnato con successo allo studente n." + (studentIndex + 1));
        } else {
            System.out.println("Indice studente non valido!");
        }
    }
}