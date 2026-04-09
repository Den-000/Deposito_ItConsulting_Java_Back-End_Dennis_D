package model.facade;

import model.computer.*;
import model.decorator.*;
import model.strategy.*;

/*
 Facade che semplifica tutte le operazioni del sistema.
 Nasconde la complessità di:
 - Creazione base PC
 - Aggiunta/rimozione componenti (Decorator)
 - Strategia pagamento (Strategy)
 */
public class FacadeOrderSystem {

    private Computer computer;                // configurazione corrente
    private PaymentStrategy paymentStrategy;  // strategia pagamento scelta

    // Crea la base del PC
    public void createBaseComputer(int type) {
        computer = (type == 1) ? new ComputerBaseOffice() : new ComputerBaseGaming();
    }

    // Aggiunge un componente extra al PC
    public void addExtraComponent(int choice) {
        if (computer == null) {
            System.out.println("Errore: scegli prima una base!");
            return;
        }

        switch (choice) {
            case 1 -> computer = new RamExtra(computer);
            case 2 -> computer = new SsdExtra(computer);
            case 3 -> computer = new GraphicsCardExtra(computer);
            case 4 -> computer = new CoolingExtra(computer);
            default -> System.out.println("Componente non valido!");
        }
    }

    // Rimuove un componente extra
    // TODO - Implementare la rimozione dei componenti extra (decorator)
    // public void removeComponent(Computer comp, int choice) {
    //     if (computer == null) return;
    // }

    // Sceglie il metodo di pagamento tramite Strategy
    public void choosePaymentMethod(int choice) {
        paymentStrategy = switch (choice) {
            case 1 -> new PaymentCard();
            case 2 -> new PaymentPaypal();
            case 3 -> new PaymentBankTransfer();
            default -> null;
        };
    }

    // Mostra riepilogo configurazione e pagamento
    public void showSummary() {
        if (computer == null) {
            System.out.println("Nessuna configurazione presente.");
            return;
        }
        System.out.println("CONFIGURAZIONE:");
        System.out.println(computer.getDescription());
        System.out.println("Prezzo: " + computer.getPrice() + "€");
        System.out.println("Metodo di pagamento: " + 
            (paymentStrategy != null ? paymentStrategy.getPaymentMethod() : "NON SELEZIONATO"));
    }

    // Mostra tutti i componenti aggiunti
    public void showComponents() {
        // TODO - Implementare una funzione che mostri solo i componenti extra aggiunti (decorator)
    }

    // Conferma l'ordine ed esegue il pagamento
    public void confirmOrder() {
        if (computer == null || paymentStrategy == null) {
            System.out.println("Configurazione incompleta!");
            return;
        }
        paymentStrategy.executePayment(computer.getPrice());
        System.out.println("Ordine completato!");
    }
}