package controller;

import java.util.List;
import model.*;
import observer.OrderObserver;
import observer.PriorityCenter;
import utility.Utility;
import view.View;

// Controller per gestire gli ordini
public class OrderController {

    private List<Order> orders;
    private PriorityCenter center;

    public OrderController(List<Order> orders) {
        this.orders = orders;
        this.center = PriorityCenter.getInstance();
    }

    // Crea un nuovo ordine e registra un observer per esso
    public void createOrder() {
        View.print("ID: ");
        int id = Utility.askInt();

        View.print("Cliente: ");
        String customer = Utility.askString();

        View.print("Prodotto: ");
        String product = Utility.askString();

        View.print("Prezzo: ");
        double price = Utility.askDouble();

        Order order = new Order(id, customer, product, price);
        orders.add(order);

        // Aggiunge observer associato a quest'ordine
        OrderObserver obs = new OrderObserver(order);
        center.addObserver(order, obs);

        View.println("Ordine creato!");
    }

    // Mostra tutti gl'ordini
    public void showOrders() {
        if (orders.isEmpty()) {
            View.println("Nessun ordine presente.");
        } else {
            View.println("ORDINI:");
            for (Order o : orders) {
                View.println(o.toString());
            }
        }
    }

    // Cambia lo stato di un ordine tramite ID e notifica gli observer
    public void changeOrderState() {
        View.print("ID ordine: ");
        int searchId = Utility.askInt();

        Order orderToChange = null;
        for (Order o : orders) if (o.getId() == searchId) orderToChange = o;

        if (orderToChange != null) {
            View.displayStateMenu();
            View.print("Imposta stato per l'ordine " + orderToChange.getId() + " a (scrivi numero): ");
            int s = Utility.askInt();

            // Imposta lo stato tramite PriorityCenter
            switch (s) {
                case 1 -> {
                    center.setOrderState(orderToChange, CenterState.NORMAL);
                    orderToChange.setFulfillment(new NormalFulfillment());
                }
                case 2 -> {
                    center.setOrderState(orderToChange, CenterState.PRIORITY);
                    orderToChange.setFulfillment(new PriorityFulfillment());
                }
                case 3 -> {
                    center.setOrderState(orderToChange, CenterState.CONTROL);
                    orderToChange.setFulfillment(new ControlledFulfillment());
                }
                default -> View.println("Stato non valido!");
            }
        } else {
            View.println("Ordine non trovato!");
        }
    }

    // Rimuove un ordine e gli eventuali observer associati
    public void removeOrder() {
        View.print("ID ordine da rimuovere: ");
        int removeId = Utility.askInt();
    
        Order orderToRemove = null;
    
        // Ricerca ordine
        for (Order o : orders) {
            if (o.getId() == removeId) {
                orderToRemove = o;
                break;
            }
        }
    
        if (orderToRemove != null) {
            // Rimuove tutti gli observer associati all'ordine dal PriorityCenter
            center.removeAllObservers(orderToRemove);
    
            // Rimuove l'ordine dalla lista
            orders.remove(orderToRemove);
    
            View.println("Ordine rimosso!");
        } else {
            View.println("Ordine non trovato!");
        }
    }
}