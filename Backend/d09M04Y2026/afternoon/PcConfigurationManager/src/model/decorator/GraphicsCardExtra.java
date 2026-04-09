package model.decorator;

import model.computer.Computer;

// Decoratore concreto: aggiunge scheda grafica
public class GraphicsCardExtra extends ExtraComponentDecorator {

    public GraphicsCardExtra(Computer computer) {
        super(computer);
    }

    public String getDescription() {
        return computer.getDescription() + " + Scheda Grafica Extra Intel Arc B580 da 12GB";
    }

    public double getPrice() {
        return computer.getPrice() + 350.00;
    }
}