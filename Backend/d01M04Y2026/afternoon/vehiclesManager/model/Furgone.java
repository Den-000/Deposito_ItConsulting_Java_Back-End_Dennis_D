package vehiclesManager.model;

import vehiclesManager.interfaces.*;

public  class Furgone extends VeicoloConsegna implements Tracciabile {

    public Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override
    public void consegnaPacco(String destinazione, float peso) {
        if (peso > getCaricoMassimo()) {
            System.out.println("Errore: carico troppo pesante per il furgone!");
        } else {
            System.out.println("Furgone con targa " + getTarga() +
                    " sta consegnando via strada a " + destinazione);
        }
    }

    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracking furgone: " + codiceTracking);
    }
}