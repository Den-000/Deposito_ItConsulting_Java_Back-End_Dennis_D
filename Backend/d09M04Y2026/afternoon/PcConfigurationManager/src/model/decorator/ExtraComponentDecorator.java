package model.decorator;

import model.computer.Computer;

// Classe astratta Decorator
// Implementa l'interfaccia Computer poiché deve essere intercambiabile con gli oggetti Computer che decora
public abstract class ExtraComponentDecorator implements Computer {

    // Oggetto da decorare
    protected Computer computer;

    public ExtraComponentDecorator(Computer computer) {
        this.computer = computer;
    }

    // Permette di accedere al computer sottostante (per rimozione)
    public Computer getWrapped() {
        return computer;
    }

    // Permette di sostituire il computer sottostante (per rimozione)
    public void setWrapped(Computer computer) {
        this.computer = computer;
    }
}