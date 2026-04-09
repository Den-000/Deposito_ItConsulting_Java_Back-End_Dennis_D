package model.strategy;

// Strategia concreta: pagamento con carta di credito/debito
public class PaymentCard implements PaymentStrategy {

    public void executePayment(double amount) {

        // Simulazione pagamento con carta
        System.out.println("Esecuzione pagamento con carta...");
        System.out.println("Importo: " + amount + " EUR");
    }

    public String getPaymentMethod() {
        return "Pagamento con carta di credito/debito";
    }
}