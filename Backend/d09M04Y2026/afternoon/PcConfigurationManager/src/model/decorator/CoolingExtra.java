package model.decorator;

import model.computer.Computer;

// Decoratore concreto: sistema di raffreddamento
public class CoolingExtra extends ExtraComponentDecorator {

    public CoolingExtra(Computer computer) {
        super(computer);
    }

    public String getDescription() {
        return computer.getDescription() + " + Sistema di Raffreddamento Liquido AIO da 240mm";
    }

    public double getPrice() {
        return computer.getPrice() + 179.99;
    }
}