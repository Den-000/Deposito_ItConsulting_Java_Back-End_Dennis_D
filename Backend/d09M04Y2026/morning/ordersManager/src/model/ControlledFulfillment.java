package model;

// Strategia controllata (Pattern Strategy)
public class ControlledFulfillment implements IFulfillmentStrategy {

    @Override
    public void execute(Order order) {
        double finalPrice = order.getPrice() * 0.95; // Sconto per controllo aggiuntivo

        System.out.println("Ordine evaso con verifica aggiuntiva");
        System.out.println("Prezzo finale: " + finalPrice);
    }
}