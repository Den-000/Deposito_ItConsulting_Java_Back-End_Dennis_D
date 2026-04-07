package view;

public class OrderView {

    // Mostra il menu principale
    public void showMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1) Inserisci ordine");
        System.out.println("2) Mostra ordini");
        System.out.println("3) Cerca ordine");
        System.out.println("4) Aggiorna stato");
        System.out.println("0) Esci");
        System.out.println("================");
    }

    // Metodo generico per stampare messaggi senza andare a capo
    public void print(String message) {
        System.out.print(message);
    }
}