package model.strategy;

// Strategia concreta: pagamento tramite bonifico bancario
public class PaymentBankTransfer implements PaymentStrategy {

    public void executePayment(double amount) {

        // Simulazione bonifico
        System.out.println("Esecuzione pagamento con bonifico bancario...");
        System.out.println("Importo: " + amount + " EUR");
    }

    public String getPaymentMethod() {
        return "Bonifico Bancario";
    }
}