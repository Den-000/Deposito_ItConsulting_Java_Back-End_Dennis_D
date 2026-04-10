package view;

public class UserView extends MainView {
    
    public void showMainMenu() {
        System.out.println("\n=== Menu Principale ===");
        System.out.println("1) Apri Catalogo");
        System.out.println("2) Cerca Prodotto");
        System.out.println("3) Visualizza Carrello");
        System.out.println("4) Impostazioni Account");
        System.out.println("0) Logout");
        System.out.println("=======================");
        System.out.print("Scelta (es. 3): ");
    }
}
