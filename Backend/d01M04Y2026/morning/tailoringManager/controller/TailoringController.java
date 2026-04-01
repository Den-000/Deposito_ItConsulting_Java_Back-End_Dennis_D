package tailoringManager.controller;

import tailoringManager.model.*;
import tailoringManager.service.*;
import tailoringManager.utility.*;
import tailoringManager.view.*;

// ===== CONTROLLO APPLICAZIONE =====
public class TailoringController {

    private TailoringService s;
    private TailoringView v;

    public TailoringController(TailoringService service, TailoringView view) {
        this.s = service;
        this.v = view;
    }

    // Metodo per inizializzare l'applicazione con dati di test e mostrare i risultati
    public void init() {

        // DATI DI TEST
        s.addGarment(new Jacket("C1", "Smoking", "Lana", "Nero", "M", 250, 2));
        s.addGarment(new Trousers("C2", "Classico", "Cotone", "Blu", "L", 120, "Slim"));

        s.addComponent(new Tie("F1", "Cravatta Seta", "Seta", "Rosso", 50, 7.5));

        // OUTPUT
        v.showGarments(s.getGarments());
        v.showComponents(s.getComponents());
    }

    // Applicazione principale con menu e sottomenu per gestire capi e componenti di finitura
    public void runApp(){
        // Variabile per gestire le scelte del menu principale
        int choice;

        // Variabile per gestire le scelte dei sottomenu
        int subChoice;

        // Variabile per gestire le scelte dei menu interni (es. tipo di capo da aggiungere)
        int internChoice;

        do {
            v.showMainMenu();
            choice = Utility.askInt();

            // Ciclo per gestire le scelte del menu principale
            switch (choice) {

                // Menu capi principali
                case 1:
                    do {
                        v.showGarmentsMenu();
                        subChoice = Utility.askInt();
            
                        // Ciclo per gestire le scelte del menu capi principali
                        switch (subChoice) {

                            // Mostra menu per scegliere il tipo di capo da aggiungere
                            case 1:
                                do {
                                    v.showGarmentsAvailableToDo();
                                    internChoice = Utility.askInt();
                        
                                    switch (internChoice) {
            
                                        // Aggiungi giacca
                                        case 1:
                                            v.showMessage("Codice:");
                                            String codeJ = Utility.askString();
                                            v.showMessage("Nome:");
                                            String nameJ = Utility.askString();
                                            v.showMessage("Tessuto:");
                                            String fabricJ = Utility.askString();
                                            v.showMessage("Colore:");
                                            String colorJ = Utility.askString();
                                            v.showMessage("Taglia:");
                                            String sizeJ = Utility.askString();
                                            v.showMessage("Prezzo:");
                                            double priceJ = Utility.askDouble();
                                            v.showMessage("Bottoni:");
                                            int buttons = Utility.askInt();

                                            s.addGarment(new Jacket(codeJ, nameJ, fabricJ, colorJ, sizeJ, priceJ, buttons));
                                            v.showMessage("Giacca aggiunta!");
                                            internChoice = 0; // Esce dal menu interno dopo l'aggiunta
                                            break;
            
                                        // Aggiungi gilet
                                        case 2:
                                            v.showMessage("Codice:");
                                            String codeV = Utility.askString();
                                            v.showMessage("Nome:");
                                            String nameV = Utility.askString();
                                            v.showMessage("Tessuto:");
                                            String fabricV = Utility.askString();
                                            v.showMessage("Colore:");
                                            String colorV = Utility.askString();
                                            v.showMessage("Taglia:");
                                            String sizeV = Utility.askString();
                                            v.showMessage("Prezzo:");
                                            double priceV = Utility.askDouble();
                                            v.showMessage("Ha la piega? (s/n):");
                                            boolean hasFold = Utility.askBoolean();
                                        
                                            s.addGarment(new Vest(codeV, nameV, fabricV, colorV, sizeV, priceV, hasFold));
                                            v.showMessage("Gilet aggiunto!");
                                            internChoice = 0; // Esce dal menu interno dopo l'aggiunta
                                            break;
                                        
                                        // Aggiungi pantalone
                                        case 3:
                                            v.showMessage("Codice:");
                                            String codeT = Utility.askString();
                                            v.showMessage("Nome:");
                                            String nameT = Utility.askString();
                                            v.showMessage("Tessuto:");
                                            String fabricT = Utility.askString();
                                            v.showMessage("Colore:");
                                            String colorT = Utility.askString();
                                            v.showMessage("Taglia:");
                                            String sizeT = Utility.askString();
                                            v.showMessage("Prezzo:");
                                            double priceT = Utility.askDouble();
                                            v.showMessage("Fit:");
                                            String fit = Utility.askString();
    
                                            s.addGarment(new Trousers(codeT, nameT, fabricT, colorT, sizeT, priceT, fit));
                                            v.showMessage("Pantalone aggiunto!");
                                            internChoice = 0; // Esce dal menu interno dopo l'aggiunta
                                            break;

                                        case 0:
                                            v.showMessage("Tornando al menu dei capi...");
                                            break;
                                        default:
                                            v.showMessage("Scelta non valida, riprova.");
                                            break;
                                    }
                        
                                } while (internChoice != 0);
                                break;

                            // Mostra tutti i capi principali
                            case 2:
                                v.showGarments(s.getGarments());
                                break;
                            
                            // Chiede codice capo, cerca e mostra dettagli
                            case 3:
                                v.showMessage("Inserisci codice:");
                                String searchCode = Utility.askString();
                                MainGarment g = s.findGarmentByCode(searchCode);
    
                                if (g != null)
                                    v.showMessage(g.showDetails());
                                else
                                    v.showMessage("Capo non trovato.");
                                break;

                            // Chiede codice capo, se trovato fai modificare il prezzo, altrimenti messaggio errore
                            case 4:
                                v.showMessage("Inserisci codice:");
                                String modCode = Utility.askString();
                                MainGarment gm = s.findGarmentByCode(modCode);
    
                                if (gm != null) {
                                    v.showMessage("Nuovo prezzo:");
                                    double newPrice = Utility.askDouble();
                                    gm.setPrice(newPrice);
                                    v.showMessage("Prezzo aggiornato!");
                                } else {
                                    v.showMessage("Capo non trovato.");
                                }
                                break;

                            // Chiede codice capo, se trovato conferma rimozione, altrimenti messaggio errore
                            case 5:
                                v.showMessage("Inserisci codice:");
                                String delCode = Utility.askString();
                                boolean removed = s.removeGarmentByCode(delCode);
    
                                if (removed)
                                    v.showMessage("Capo rimosso.");
                                else
                                    v.showMessage("Capo non trovato.");
                                break;
                            case 0:
                                v.showMessage("Tornando al menu principale...");
                                break;
                            default:
                                v.showMessage("Scelta non valida, riprova.");
                                break;
                        }
            
                    } while (subChoice != 0);
                    break;





                // Menu componenti di finitura
                case 2: 
                    do {
                        v.showComponentsMenu();
                        subChoice = Utility.askInt();
            
                        // Ciclo per gestire le scelte del menu componenti di finitura
                        switch (subChoice) {
                            // Mostra menu per scegliere il tipo di componente da aggiungere
                            case 1:
                                do {
                                    v.showComponentsAvailableToDo();
                                    internChoice = Utility.askInt();
                        
                                    switch (internChoice) {
            
                                        // Aggiungi cravatta
                                        case 1:
                                            v.showMessage("Codice:");
                                            String codeT = Utility.askString();
                                            v.showMessage("Nome:");
                                            String nameT = Utility.askString();
                                            v.showMessage("Materiale:");
                                            String materialT = Utility.askString();
                                            v.showMessage("Colore:");
                                            String colorT = Utility.askString();
                                            v.showMessage("Prezzo:");
                                            double priceT = Utility.askDouble();
                                            v.showMessage("Larghezza:");
                                            double width = Utility.askDouble();

                                            s.addComponent(new Tie(codeT, nameT, materialT, colorT, priceT, width));
                                            v.showMessage("Cravatta aggiunta!");
                                            internChoice = 0; // Esce dal menu interno dopo l'aggiunta
                                            break;
            
                                        // Aggiungi papillon
                                        case 2:
                                            v.showMessage("Codice:");
                                            String codeP = Utility.askString();
                                            v.showMessage("Nome:");
                                            String nameP = Utility.askString();
                                            v.showMessage("Materiale:");
                                            String materialP = Utility.askString();
                                            v.showMessage("Colore:");
                                            String colorP = Utility.askString();
                                            v.showMessage("Prezzo:");
                                            double priceP = Utility.askDouble();
                                            v.showMessage("Forma (classico/diamante):");
                                            String shape = Utility.askString();

                                            s.addComponent(new BowTie(codeP, nameP, materialP, colorP, priceP, shape));
                                            v.showMessage("Papillon aggiunto!");
                                            internChoice = 0; // Esce dal menu interno dopo l'aggiunta
                                            break;
                                        
                                        // Aggiungi pochette
                                        case 3:
                                            v.showMessage("Codice:");
                                            String codePo = Utility.askString();
                                            v.showMessage("Nome:");
                                            String namePo = Utility.askString();
                                            v.showMessage("Materiale:");
                                            String materialPo = Utility.askString();
                                            v.showMessage("Colore:");
                                            String colorPo = Utility.askString();
                                            v.showMessage("Prezzo:");
                                            double pricePo = Utility.askDouble();
                                            v.showMessage("Dimensione (piccola/media/grande):");
                                            String size = Utility.askString();

                                            s.addComponent(new PocketSquare(codePo, namePo, materialPo, colorPo, pricePo, size));
                                            v.showMessage("Pochette aggiunta!");
                                            internChoice = 0; // Esce dal menu interno dopo l'aggiunta
                                            break;

                                        case 0:
                                            v.showMessage("Tornando al menu dei componenti...");
                                            break;
                                        default:
                                            v.showMessage("Scelta non valida, riprova.");
                                            break;
                                    }
                        
                                } while (internChoice != 0);
                                break;

                            // Mostra tutti i componenti di finitura
                            case 2:
                                v.showComponents(s.getComponents());
                                break;
    
                            // Chiede codice componente, cerca e mostra dettagli
                            case 3:
                                v.showMessage("Codice:");
                                String c = Utility.askString();
                                FinishingComponent comp = s.findComponentByCode(c);
    
                                if (comp != null)
                                    v.showMessage(comp.showDetails());
                                else
                                    v.showMessage("Non trovato.");
                                break;
    
                            // Chiede codice componente, se trovato fai modificare il prezzo, altrimenti messaggio errore
                            case 4:
                                v.showMessage("Codice:");
                                String mc = Utility.askString();
                                FinishingComponent cmp = s.findComponentByCode(mc);
    
                                if (cmp != null) {
                                    v.showMessage("Nuovo prezzo:");
                                    cmp.setPrice(Utility.askDouble());
                                    v.showMessage("Aggiornato!");
                                } else {
                                    v.showMessage("Non trovato.");
                                }
                                break;
    
                            // Chiede codice componente, se trovato conferma rimozione, altrimenti messaggio errore
                            case 5:
                                v.showMessage("Codice:");
                                String dc = Utility.askString();
                                boolean rem = s.removeComponentByCode(dc);
                                if (rem)
                                    v.showMessage("Rimosso.");
                                else
                                    v.showMessage("Non trovato.");
                                break;
                            case 0:
                                v.showMessage("Tornando al menu principale...");
                                break;
                            default:
                                v.showMessage("Scelta non valida, riprova.");
                                break;
                        }
            
                    } while (subChoice != 0);
                    break;
                case 0:
                    v.showMessage("Arrivederci!");
                    break;
                default:
                    v.showMessage("Scelta non valida, riprova.");
                    break;
            }

        } while (choice != 0);
    }
}