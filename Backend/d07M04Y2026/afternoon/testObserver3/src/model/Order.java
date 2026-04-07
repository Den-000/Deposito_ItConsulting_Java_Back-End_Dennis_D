package model;

public class Order {

    // Attributi dell'ordine
    private int id;
    private String customer;
    private String product;
    private int quantity;
    private String state;

    // Costruttore parametrizzato
    public Order(int id, String customer, String product, int quantity, String state) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.state = state;
    }

    // Getter
    public int getId() { return id; }
    public String getCustomer() { return customer; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public String getState() { return state; }

    // Setter per modificare lo stato
    public void setState(String state) { this.state = state; }

    // Rappresentazione testuale dell'oggetto
    @Override
    public String toString() {
        return "ID: " + id + ", Cliente: " + customer + ", Prodotto: " + product +
                ", Quantità: " + quantity + ", Stato: " + state;
    }
}