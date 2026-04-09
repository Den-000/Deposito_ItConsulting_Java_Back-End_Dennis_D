package controller;

import model.IOperazione;

public class Calcolatore {
    private IOperazione operazione;

    // Imposta la strategia
    public void setOperazione(IOperazione operazione) {
        this.operazione = operazione;
    }

    // Esegue l'operazione
    public int calcola(int a, int b) {
        if (operazione == null) {
            throw new IllegalStateException("Operazione non impostata!");
        }
        return operazione.esegui(a, b);
    }
}