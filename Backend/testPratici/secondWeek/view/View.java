package view;

import java.util.Scanner;

public class View {
     // Classe per la gestione input/output
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n=== MENU SCUOLA ===");
        System.out.println("1. Crea studente");
        System.out.println("2. Crea docente");
        System.out.println("3. Assegna voto");
        System.out.println("4. Stampa voti studente");
        System.out.println("0. Esci");
        System.out.println("===================");
        System.out.print("Seleziona un'opzione:");

        return scanner.nextInt();
    }

    public String getStringInput(String message) {
        System.out.print(message);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public int getIntInput(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}
