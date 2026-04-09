package model;

// Interfaccia per le strategie di evasione
public interface IFulfillmentStrategy {
    void execute(Order order); // Ogni strategia dovrà implementare questo metodo
}