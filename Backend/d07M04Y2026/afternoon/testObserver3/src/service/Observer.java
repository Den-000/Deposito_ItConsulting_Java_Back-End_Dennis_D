package service;

import java.util.ArrayList;
import java.util.List;

import model.Order;

public class Observer {

    // Interfaccia Observer (chi riceve aggiornamenti)
    interface ObserverInterface {
        void update(Order order);
    }

    // Interfaccia Subject (chi notifica)
    interface Subject {
        void addObserver(ObserverInterface o);
        void removeObserver(ObserverInterface o);
        void notifyObservers(Order order);
    }

    // Implementazione concreta del Subject
    public class OrdersManager implements Subject {

        // Lista degli osservatori registrati
        private List<ObserverInterface> observers = new ArrayList<>();

        // Aggiunge un observer
        @Override
        public void addObserver(ObserverInterface o) {
            observers.add(o);
        }

        // Rimuove un observer
        @Override
        public void removeObserver(ObserverInterface o) {
            observers.remove(o);
        }

        // Notifica tutti gli observer
        @Override
        public void notifyObservers(Order order) {
            for (ObserverInterface o : observers) {
                o.update(order);
            }
        }
    }
}