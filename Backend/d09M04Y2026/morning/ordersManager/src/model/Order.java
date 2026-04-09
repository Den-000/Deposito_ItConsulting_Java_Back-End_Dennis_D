package model;

// Classe modello per un ordine
public class Order {
    private int id;
    private String customer;
    private String product;
    private double price;
    private CenterState state;
    private IFulfillmentStrategy fulfillment;

    public Order(int id, String customer, String product, double price) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.price = price;
        this.state = CenterState.NORMAL; // Stato normale di default
        this.fulfillment = new NormalFulfillment(); // Strategia di fulfillment di default
    }

    // Getter e setter
    public int getId() { return id; }
    public String getCustomer() { return customer; }
    public String getProduct() { return product; }
    public double getPrice() { return price; }
    public CenterState getState() { return state; }
    public IFulfillmentStrategy getFulfillment() { return fulfillment; }

    public void setState(CenterState state) {
        this.state = state;
    }

    public void setFulfillment(IFulfillmentStrategy fulfillment) {
        this.fulfillment = fulfillment;
    }

    // Output leggibile
    @Override
    public String toString() {
        return "Ordine ID: " + id +
               ", Cliente: " + customer +
               ", Prodotto: " + product +
               ", Prezzo: " + price +
               ", Stato: " + state +
               ", Strategia: " + fulfillment.getClass().getSimpleName();
    }
}