package d24M03Y2026.afternoon.threeShopsManager.controller;

import d24M03Y2026.afternoon.threeShopsManager.model.Product;
import d24M03Y2026.afternoon.threeShopsManager.model.Shop;
import template.utility.Utility;
import template.view.View;

// Classe principale: gestisce il menu e le operazioni sui negozi
public class Main {
    public static void main(String[] args) {

        // Creazione dei tre negozi
        Shop shop1 = new Shop("Alcott");
        Shop shop2 = new Shop("Zara");
        Shop shop3 = new Shop("Bershka");

        int choice;

        // Ciclo principale del programma (menu)
        do {
            showMenu();
            View.print("Scelta: \n");
            choice = Utility.askInt(); // Lettura input utente

            // Gestione delle opzioni
            switch (choice) {
                case 1: // Inserimento prodotto
                    insertProduct(shop1, shop2, shop3);
                    break;
                case 2: // Visualizzazione negozi
                    showAllShops(shop1, shop2, shop3);
                    break;
                case 3: // Negozio con prodotto più costoso
                    showMostExpensiveShop(shop1, shop2, shop3);
                    break;
                case 4: // Modifica quantità
                    updateQuantity(shop1, shop2, shop3);
                    break;
                case 5: // Vendita prodotto
                    sellProduct(shop1, shop2, shop3);
                    break;
                case 6: // Uscita
                    View.print("Uscita...\n");
                    break;
                default:
                    View.print("Scelta non valida\n");
            }

        } while (choice != 6); // Continua finché non si sceglie "Esci"
    }

    // Stampa il menu
    static void showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1) Inserisci prodotto in un negozio");
        System.out.println("2) Visualizza dati di tutti i negozi");
        System.out.println("3) Cerca negozio con prodotto più costoso");
        System.out.println("4) Modifica quantità di un prodotto");
        System.out.println("5) Vendi prodotti da un negozio");
        System.out.println("6) Esci");
        System.out.println("================");
    }

    // Inserisce un prodotto in uno dei negozi
    static void insertProduct(Shop s1, Shop s2, Shop s3) {
        View.print("Seleziona negozio (1-3): \n");
        int shopChoice = Utility.askInt();

        // Input dati prodotto
        View.print("Nome prodotto: \n");
        String name = Utility.askString();
        View.print("Prezzo: \n");
        double price = Utility.askDouble();
        View.print("Quantità: \n");
        int quantity = Utility.askInt();

        // Creazione oggetto prodotto
        Product p = new Product(name, price, quantity);

        // Assegna il prodotto al negozio scelto
        switch (shopChoice) {
            case 1: s1.setProduct(p); break;
            case 2: s2.setProduct(p); break;
            case 3: s3.setProduct(p); break;
            default:
                View.print("Scelta non valida! \n");
                return;
        }

        View.print("Prodotto inserito!\n");
    }

    // Mostra tutti i negozi
    static void showAllShops(Shop s1, Shop s2, Shop s3) {
        s1.showShopData();
        s2.showShopData();
        s3.showShopData();
    }

    // Trova il negozio con il prodotto più costoso
    static void showMostExpensiveShop(Shop s1, Shop s2, Shop s3) {
        Shop maxShop = s1;

        // Confronto con secondo negozio
        if (s2.getProduct() != null &&
           (maxShop.getProduct() == null ||
            s2.getProduct().getPrice() > maxShop.getProduct().getPrice())) {
            maxShop = s2;
        }

        // Confronto con terzo negozio
        if (s3.getProduct() != null &&
           (maxShop.getProduct() == null ||
            s3.getProduct().getPrice() > maxShop.getProduct().getPrice())) {
            maxShop = s3;
        }

        // Output risultato
        if (maxShop.getProduct() != null) {
            View.print("Negozio con prodotto più costoso: " +
                    maxShop.getName() + " -> " +
                    maxShop.getProduct().getName() + " - " +
                    maxShop.getProduct().getPrice() + " €\n");
        } else {
            View.print("Nessun prodotto presente nei negozi.\n");
        }
    }

    // Aggiorna la quantità di un prodotto
    static void updateQuantity(Shop s1, Shop s2, Shop s3) {
        View.print("Seleziona negozio (1-3): \n");
        int shopChoice = Utility.askInt();

        View.print("Nuova quantità: \n");
        int quantity = Utility.askInt();

        // Aggiornamento quantità
        switch (shopChoice) {
            case 1:
                if (s1.getProduct() != null)
                    s1.getProduct().setQuantity(quantity);
                break;
            case 2:
                if (s2.getProduct() != null)
                    s2.getProduct().setQuantity(quantity);
                break;
            case 3:
                if (s3.getProduct() != null)
                    s3.getProduct().setQuantity(quantity);
                break;
            default:
                View.print("Scelta non valida! \n");
                return;
        }

        View.print("Quantità aggiornata!\n");
    }

    // Vende una quantità di prodotto
    static void sellProduct(Shop s1, Shop s2, Shop s3) {
        View.print("Seleziona negozio (1-3): \n");
        int shopChoice = Utility.askInt();

        View.print("Quantità da vendere: \n");
        int quantity = Utility.askInt();

        // Richiama il metodo di vendita del negozio
        switch (shopChoice) {
            case 1: s1.sellProduct(quantity); break;
            case 2: s2.sellProduct(quantity); break;
            case 3: s3.sellProduct(quantity); break;
            default:
                View.print("Scelta non valida! \n");
        }
    }
}