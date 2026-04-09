package controller;
import model.facade.FacadeOrderSystem;

/*
  Controller tra View e Model.
  Tutti i comandi passano attraverso il Facade per semplificare la logica.
 */
public class OrderController {

    private FacadeOrderSystem facade; // Facade per la gestione degl'ordini

    public OrderController() {
        facade = new FacadeOrderSystem();
    }

    // Creazione della base del PC (ufficio o gaming, in base alla scelta dell'utente)
    public void createBaseComputer(int type) {
        facade.createBaseComputer(type);
    }

    // Aggiunta componente extra (RAM, SSD, GPU, Cooling, in base alla scelta dell'utente)
    public void addComponent(int choice) {
        facade.addExtraComponent(choice);
    }

    // Rimozione componente extra (identificato dalla scelta dell'utente)
    public void removeComponent(int choice) {
        // TODO - implementare rimozione componente (facade.removeComponent(computer, choice))
        // facade.removeComponent(choice);
    }

    // Scelta metodo di pagamento (Strategy, in base alla scelta dell'utente)
    public void choosePayment(int choice) {
        facade.choosePaymentMethod(choice);
    }

    // Mostra riepilogo configurazione
    public void showSummary() {
        facade.showSummary();
    }

    // Mostra lista componenti aggiunti
    public void showComponents() {
        facade.showComponents();
    }

    // Conferma ordine ed applica pagamento
    public void confirmOrder() {
        facade.confirmOrder();
    }
}