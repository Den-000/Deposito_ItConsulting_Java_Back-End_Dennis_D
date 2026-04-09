package model;

// Strategia standard
public class NormalFulfillment implements IFulfillmentStrategy {

    @Override
    public void execute(Order order) {
        double finalPrice = order.getPrice() * 1.05; // Costo aggiuntivo per procedura standard

        System.out.println("Ordine evaso con procedura standard");
        System.out.println("Prezzo finale: " + finalPrice);
    }
}