package d20M03Y2026.afternoon.carManager.view;

// Classe View: gestisce tutta la parte di output a schermo
public class View {

    // ======================
    // METODI PER IL MENU
    // ======================

    // Mostra il menu principale del programma
    public static void showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1) Inserisci veicolo");
        System.out.println("2) Visualizza tutti");
        System.out.println("3) Modifica prezzo");
        System.out.println("4) Verifica età");
        System.out.println("5) Esci");
        System.out.println("================");
    }

    // ======================
    // METODI PER LA VISUALIZZAZIONE DEI DETTAGLI
    // ======================

    // Stampa i dettagli di un veicolo con indice
    public static void printDetails(int i, String brand, String model, int year, double price){
        System.out.println(i + ") " + brand + " " + model + " - " + year + " - " + price + " €");
    }

    // Stampa un messaggio generico a schermo
    public static void showMessage(String msg) {
        System.out.println(msg);
    }
}