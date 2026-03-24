package d24M03Y2026.afternoon.threeShopsManager.model;

// Classe che rappresenta un prodotto
public class Product {

    private String name;   // Nome del prodotto
    private double price;  // Prezzo
    private int quantity;  // Quantità disponibile

    // Costruttore: inizializza il prodotto
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // ===== GETTER =====

    // Restituisce il nome
    public String getName() {
        return name;
    }

    // Restituisce il prezzo
    public double getPrice() {
        return price;
    }

    // Restituisce la quantità
    public int getQuantity() {
        return quantity;
    }

    // ===== SETTER =====

    // Modifica nome
    public void setName(String name) {
        this.name = name;
    }

    // Modifica prezzo
    public void setPrice(double price) {
        this.price = price;
    }

    // Modifica quantità
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}