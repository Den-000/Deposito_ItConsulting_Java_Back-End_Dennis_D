package model.decorator;

import model.computer.Computer;

// Decoratore concreto: aggiunge SSD
public class SsdExtra extends ExtraComponentDecorator {

    public SsdExtra(Computer computer) {
        super(computer);
    }

    // Aggiunge descrizione
    public String getDescription() {
        return computer.getDescription() + " + SSD Extra da 1TB";
    }

    // Aggiunge costo
    public double getPrice() {
        return computer.getPrice() + 800.00;
    }
}