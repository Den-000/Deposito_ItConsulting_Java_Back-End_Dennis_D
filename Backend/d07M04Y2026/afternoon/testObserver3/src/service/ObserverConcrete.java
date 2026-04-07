package service;

import model.Order;
import service.Observer.ObserverInterface;

public class ObserverConcrete {

    // Observer per il magazzino
    public class WarehouseDepartment implements ObserverInterface {

        @Override
        public void update(Order o) {

            // Reagisce solo se lo stato è "IN PREPARAZIONE"
            if (o.getState().equals("IN PREPARAZIONE")) {
                System.out.println("[MAGAZZINO] Preparare ordine " + o.getId());
            }
        }
    }

    // Observer per le spedizioni
    public class ShippingDepartment implements ObserverInterface {

        @Override
        public void update(Order o) {

            // Reagisce solo se lo stato è "SPEDITO"
            if (o.getState().equals("SPEDITO")) {
                System.out.println("[SPEDIZIONI] Ordine " + o.getId() + " spedito");
            }
        }
    }

    // Observer per notifiche generiche al cliente
    public class SystemNotifications implements ObserverInterface {

        @Override
        public void update(Order o) {

            // Notifica sempre qualsiasi cambiamento di stato
            System.out.println("[NOTIFICA CLIENTE] Ordine " + o.getId() + " ora è: " + o.getState());
        }
    }
}