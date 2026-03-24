package d24M03Y2026.afternoon.threeShopsManager.model;

import template.view.View;

// Classe che rappresenta un negozio
public class Shop {

    private String name;     // Nome del negozio
    private Product product; // Prodotto gestito (uno solo)

    // Costruttore
    public Shop(String name) {
        this.name = name;
        this.product = null; // Nessun prodotto inizialmente
    }

    // ===== GETTER =====

    public String getName() {
        return name;
    }

    public Product getProduct() {
        return product;
    }

    // ===== METODI =====

    // Inserisce o sostituisce il prodotto del negozio
    public void setProduct(Product product) {
        this.product = product;
    }

    // Mostra i dati del negozio e del prodotto
    public void showShopData() {
        if (product != null) {
            View.print(name + " -> " +
                       product.getName() + " - " +
                       product.getPrice() + " € - " +
                       product.getQuantity() + " disponibili\n");
        } else {
            View.print(name + " -> Nessun prodotto\n");
        }
    }

    // Vende una certa quantità di prodotto
    public void sellProduct(int quantity) {

        // Nessun prodotto presente
        if (product == null) {
            View.print("Nessun prodotto da vendere in " + name + "\n");
            return;
        }

        // Quantità non valida
        if (quantity <= 0) {
            View.print("Quantità non valida\n");
            return;
        }

        // Quantità richiesta maggiore di quella disponibile
        if (quantity > product.getQuantity()) {
            View.print("Quantità disponibile insufficiente. Venduti solo " +
                       product.getQuantity() + "\n");
            product.setQuantity(0);
        } else {
            // Vendita normale
            product.setQuantity(product.getQuantity() - quantity);
            View.print("Venduti " + quantity + " " + product.getName() + "\n");
        }
    }
}