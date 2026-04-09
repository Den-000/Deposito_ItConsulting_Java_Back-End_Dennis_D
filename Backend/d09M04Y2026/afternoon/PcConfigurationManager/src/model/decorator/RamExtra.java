package model.decorator;

import model.computer.Computer;

// Decoratore concreto: aggiunge RAM
public class RamExtra extends ExtraComponentDecorator {

    // Costruttore che accetta un oggetto Computer da decorare
    public RamExtra(Computer computer) {
        super(computer);
    }

    // Implementazione del metodo getDescription per aggiungere la descrizione della RAM extra
    public String getDescription() {
        return computer.getDescription() + " + RAM Extra da 16GB";
    }

    // Implementazione del metodo getPrice per aggiungere il costo della RAM extra al prezzo totale
    public double getPrice() {
        return computer.getPrice() + 650.00;
    }
}