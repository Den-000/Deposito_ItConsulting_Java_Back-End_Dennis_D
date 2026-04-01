package vehiclesManager.model;

import vehiclesManager.interfaces.*;

public class Drone extends VeicoloConsegna implements Tracciabile {

    public Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override
    public void consegnaPacco(String destinazione, float peso) {
        if (peso > getCaricoMassimo()) {
            System.out.println("Errore: carico troppo pesante per il drone!");
        } else {
            System.out.println("Drone con targa " + getTarga() + "  sta volando verso " + destinazione);
        }
    }

    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracking drone: " + codiceTracking);
    }
}