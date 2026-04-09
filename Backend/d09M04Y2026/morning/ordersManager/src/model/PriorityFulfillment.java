package model;

// Strategia prioritaria
public class PriorityFulfillment implements IFulfillmentStrategy {

    @Override
    public void execute(Order order) {
        double finalPrice = order.getPrice() * 1.15; // Costo aggiuntivo per procedura prioritaria

        System.out.println("Ordine evaso con corsia prioritaria");
        System.out.println("Prezzo finale: " + finalPrice);
    }
}