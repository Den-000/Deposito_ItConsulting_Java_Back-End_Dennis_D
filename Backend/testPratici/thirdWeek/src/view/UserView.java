package view;

public class UserView extends MainView {
    
    public void showMainMenu() {
        System.out.println("\n=== Menu Principale ===");
        System.out.println("1) Apri Catalogo");
        System.out.println("2) Cerca Prodotto");
        System.out.println("3) Visualizza Carrello");
        System.out.println("4) Visualizza Ordini");
        System.out.println("5) Impostazioni Account");
        System.out.println("0) Logout");
        System.out.println("=======================");
        System.out.print("Scelta (es. 1): ");
    }

    public void openCatalogueMenu() {
        System.out.println("\n=== Catalogo ===");
        System.out.println("1) Visualizza Tutti i Prodotti");
        System.out.println("2) Visualizza Prodotti Filtrati");
        System.out.println("0) Torna al Menu Principale");
        System.out.println("=================");
        System.out.print("Scelta (es. 1): ");
    }

    public void openFilteredProductsMenu() {
        // TODO: Aggiungere opzioni di filtro più specifiche (es. per marca, valutazione, ecc.) e possibilità di combinare più filtri
        System.out.println("\n=== Filtra Prodotti ===");
        System.out.println("1) Per Categoria");
        System.out.println("2) Per Prezzo");
        System.out.println("0) Torna al Catalogo");
        System.out.println("=====================");
        System.out.print("Scelta (es. 1): ");
    }
}
