package model.strategy;

// Interfaccia del pattern Strategy
// Definisce il comportamento comune per tutti i metodi di pagamento
public interface PaymentStrategy {

    void executePayment(double amount);

    String getPaymentMethod();
}