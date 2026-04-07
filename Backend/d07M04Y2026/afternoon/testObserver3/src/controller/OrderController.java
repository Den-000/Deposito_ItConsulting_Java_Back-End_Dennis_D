package controller;

import java.sql.SQLException;

import dao.OrderManager;
import model.Order;
import service.Observer;
import service.ObserverConcrete;
import utility.Utility;

public class OrderController {

    // DAO per gestione ordini sul DB
    private OrderManager dao;

    // Blocco di inizializzazione (inizializza il DAO)
    {
        try {
            dao = new OrderManager();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Errore", e);
        }
    }

    // Gestione Observer
    private Observer observer = new Observer();
    private Observer.OrdersManager observerOrderManager = observer.new OrdersManager();
    private ObserverConcrete observerConcrete = new ObserverConcrete();

    // Costruttore → registra gli observer
    public OrderController() {
        observerOrderManager.addObserver(observerConcrete.new WarehouseDepartment());
        observerOrderManager.addObserver(observerConcrete.new ShippingDepartment());
        observerOrderManager.addObserver(observerConcrete.new SystemNotifications());
    }

    // Inserisce un nuovo ordine
    public void insert() {

        System.out.print("ID: ");
        int id = Utility.askInt();

        System.out.print("Cliente: ");
        String customer = Utility.askString();

        System.out.print("Prodotto: ");
        String product = Utility.askString();

        System.out.print("Quantità: ");
        int q = Utility.askInt();

        // Stato iniziale = CREATO
        Order o = new Order(id, customer, product, q, "CREATO");

        dao.insertOrder(o);
    }

    // Mostra tutti gli ordini
    public void showAll() {
        for (Order o : dao.getAllOrders()) {
            System.out.println(o);
        }
    }

    // Cerca un ordine per ID
    public void findById(int id) {
        Order o = dao.getOrderById(id);

        // Stampa risultato o messaggio di errore
        System.out.println(o != null ? o : "Non trovato");
    }

    // Modifica stato ordine e notifica observer
    public void modifyOrderState() {

        System.out.print("ID ordine: ");
        int id = Utility.askInt();

        System.out.print("Nuovo stato: ");
        String newState = Utility.askString();

        // Aggiorna nel DB
        dao.modifyOrderState(id, newState);

        // Recupera ordine aggiornato
        Order o = dao.getOrderById(id);

        // Notifica gli observer se esiste
        if (o != null)
            observerOrderManager.notifyObservers(o);
    }
}