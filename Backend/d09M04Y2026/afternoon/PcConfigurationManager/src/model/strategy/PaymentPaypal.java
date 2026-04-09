package model.strategy;

// Strategia concreta: pagamento tramite PayPal
public class PaymentPaypal implements PaymentStrategy {

    // Implementazione del metodo di pagamento
    public void executePayment(double amount) {

        // Simulazione del pagamento
        System.out.println("Esecuzione pagamento con PayPal...");
        System.out.println("Importo: " + amount + " EUR");
    }

    public String getPaymentMethod() {
        return "PayPal";
    }
}