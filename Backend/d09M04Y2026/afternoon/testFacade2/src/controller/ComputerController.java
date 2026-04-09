package controller;

import model.ComputerFacade;
import view.ComputerView;

public class ComputerController {

    private ComputerFacade facade;
    private ComputerView view;

    public ComputerController(ComputerFacade facade, ComputerView view) {
        this.facade = facade;
        this.view = view;
    }

    public void accendiComputer() {
        view.mostraMessaggio("Avvio del computer...");
        facade.accendiComputer();
        view.mostraMessaggio("Computer avviato con successo!");
    }
}