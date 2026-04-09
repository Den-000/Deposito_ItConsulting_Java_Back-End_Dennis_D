package view;

// Si occupa di avviare il controller
public class ConsoleView {

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void displayMainMenu() {
        System.out.println("\n=== Menu Principale ===");
        System.out.println("1) Crea nuova configurazione");
        System.out.println("0) Esci");
        System.out.println("========================");
        System.out.print("Scelta: ");
    }

    public void displayConfigurationMenu(boolean hasBase) {
        System.out.println("\n=== Menu Configurazione ===");
        if (!hasBase) {
            System.out.println("1) Scegli base configurazione");
        } else {
            System.out.println("1) Riepilogo configurazione");
            System.out.println("2) Aggiungi componente");
            System.out.println("3) Rimuovi componente");
            System.out.println("9) Conferma configurazione");
        }
        System.out.println("0) Torna al menu principale");
        System.out.println("==========================");
        System.out.print("Scelta: ");
    }


    public void chooseComputerBaseMenu() {
        System.out.println("\n=== Scegli Base Configurazione ===");
        System.out.println("1) Base Ufficio");
        System.out.println("2) Base Gaming");
        System.out.println("0) Torna al menu precedente");
        System.out.println("===============================");
        System.out.print("Scelta: ");
    }

    public void chooseComponentMenu() {
        System.out.println("\n=== Aggiungi Componente ===");
        System.out.println("1) RAM extra");
        System.out.println("2) SSD extra");
        System.out.println("3) Scheda grafica extra");
        System.out.println("4) Sistema di raffreddamento extra");
        System.out.println("0) Torna al menu precedente");
        System.out.println("===========================");
        System.out.print("Scelta: ");
    }

     public void choosePaymentMenu() {
        System.out.println("\n=== Scegli Metodo di Pagamento ===");
        System.out.println("1) Carta di credito");
        System.out.println("2) PayPal");
        System.out.println("3) Bonifico bancario");
        System.out.println("0) Torna al menu precedente");
        System.out.println("===============================");
        System.out.print("Scelta: ");
    }
}