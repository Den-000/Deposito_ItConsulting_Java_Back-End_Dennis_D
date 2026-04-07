package controller;

import model.Logger;          // Import della classe Logger (Singleton)
import view.ConsoleView;      // Import della vista per stampare messaggi

public class AppController {

    // Metodo principale che avvia un'operazione
    public void executeOperation() {
        ConsoleView view = new ConsoleView();   // Creazione della vista
        Logger logger1 = Logger.getInstance(); // Ottiene l'unica istanza di Logger (Singleton)

        // Stampa messaggio con riferimento all'istanza logger
        view.showMsg("Esecuzione operazione 1 da: " + logger1);

        // Chiama un'altra operazione passando la stessa vista ed il logger
        executeOtherOperation(view, logger1);
    }

    // Metodo privato che esegue una seconda operazione
    private void executeOtherOperation(ConsoleView view, Logger logger) {

        // Ottiene nuovamente l'istanza di Logger
        Logger logger2 = Logger.getInstance();

        // Stampa messaggio con la seconda variabile logger
        view.showMsg("Esecuzione operazione 2 da: " + logger2);

        // Verifica se logger1 e logger2 sono la stessa istanza (Singleton)
        view.showMsg("Stessa istanza? " + (logger2 == logger));
    }
}