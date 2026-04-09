package observer;

import model.Order;

// Interfaccia Observer
public interface IObserver {
    void update(Order order); // Metodo chiamato quando l'ordine viene aggiornato
}