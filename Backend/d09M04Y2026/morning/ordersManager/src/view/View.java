package view;

// Classe per gestire output a console
public class View {

    public static void println(String message) { System.out.println(message); }
    public static void print(String message) { System.out.print(message); }

    // Menu principale
    public static void displayMenu() {
        System.out.println("\n===== GESTIONALE ORDINI =====");
        System.out.println("1) Crea ordine");
        System.out.println("2) Mostra ordini");
        System.out.println("3) Imposta stato ordine");
        System.out.println("4) Rimuovi ordine");
        System.out.println("0) Esci");
        System.out.println("==============================");
    }

    // Menu per scegliere stato
    public static void displayStateMenu() {
        System.out.println("\nScegli nuovo stato:");
        System.out.println("1) Normale");
        System.out.println("2) Prioritario");
        System.out.println("3) Controllato");
    }
}