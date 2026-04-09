package observer;

import model.Order;

// Implementazione concreta dell'observer per un singolo ordine
public class OrderObserver implements IObserver {
    @SuppressWarnings("unused")
    private Order order; // Ordine monitorato

    public OrderObserver(Order order) {
        this.order = order;
    }

    @Override
    public void update(Order order) {
        System.out.println("Ordine " + order.getId() + " aggiornato.\nNuovo stato: " + order.getState());
    }
}