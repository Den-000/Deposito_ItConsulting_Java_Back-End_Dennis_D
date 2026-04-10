package view;

public abstract class MainView {

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void showLoginMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1) Login");
        System.out.println("2) Registrazione");
        System.out.println("0) Esci");
        System.out.println("============");
        System.out.print("Scelta (es. 1): ");
    }

    public abstract void showMainMenu();
    
}
