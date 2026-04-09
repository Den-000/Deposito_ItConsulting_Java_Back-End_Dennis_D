package observer;

import model.CenterState;
import model.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Singleton che gestisce gli observer degli ordini.
 Associa ogni ordine al suo observer e notifica correttamente solo gli observer degli ordini aggiornati/interessati.
 */
public class PriorityCenter {

    private static PriorityCenter instance;

    // Mappa ordine -> lista observer
    private Map<Order, List<IObserver>> observersMap;

    private PriorityCenter() {
        observersMap = new HashMap<>();
    }

    // Istanza singleton
    public static PriorityCenter getInstance() {
        if (instance == null) {
            instance = new PriorityCenter();
        }
        return instance;
    }

    // Aggiunge un observer per un ordine specifico
    public void addObserver(Order order, IObserver observer) {
        // Controlla se esiste già una lista di observer per questo ordine
        List<IObserver> list = observersMap.get(order);
    
        if (list == null) {
            // Se non esiste, crea una nuova lista
            list = new ArrayList<>();
            observersMap.put(order, list); // associa la lista all'ordine nella mappa
        }
    
        // Aggiunge l'observer alla lista
        list.add(observer);
    }

    // Rimuove un observer per un ordine specifico
    public void removeObserver(Order order, IObserver observer) {
        List<IObserver> list = observersMap.get(order);
        if (list != null) {
            list.remove(observer);
            if (list.isEmpty()) observersMap.remove(order);
        }
    }

    // Rimuove tutti gli observer associati ad un ordine specifico
    public void removeAllObservers(Order order) {
        observersMap.remove(order); // rimuove la lista associata
    }

    // Notifica tutti gli observer di un ordine specifico
    public void notifyObservers(Order order) {
        List<IObserver> list = observersMap.get(order);
        if (list != null) {
            for (IObserver obs : list) {
                obs.update(order);
            }
        }
    }

    // Cambia lo stato di un ordine e notifica solo gli observer interessati
    public void setOrderState(Order order, CenterState state) {
        order.setState(state);
        notifyObservers(order);
    }
}