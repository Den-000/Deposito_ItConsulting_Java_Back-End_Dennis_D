import controller.OrderController;
import view.ConsoleView;
import view.utility.Utility;

public class App {

    public static void main(String[] args) throws Exception {

        // Creazione del controller (gestisce la logica tra View e Model)
        OrderController controller = new OrderController();

        // Creazione della view per l'interfaccia console
        ConsoleView view = new ConsoleView();

        // Utility per input da console (singleton)
        Utility u = Utility.getInstance();

        // Flag per verificare se è stata scelta la base del PC
        boolean hasBase = false;

        int choice; // scelta principale del menu

        // Ciclo principale del menu principale
        do {
            view.displayMainMenu();      // mostra il menu principale
            choice = u.askInt();         // chiede input all'utente

            switch (choice) {
                case 1: // Nuova configurazione
                    int subChoice; // scelta del menu secondario

                    // Ciclo menu configurazione
                    do {
                        view.displayConfigurationMenu(hasBase); // mostra menu configurazione
                        subChoice = u.askInt();                 // input dell'utente

                        if (!hasBase) { // Se non è stata scelta la base, l'unica opzione è selezionarla
                            if (subChoice == 1) {
                                do {
                                    view.chooseComputerBaseMenu(); // menu scelta base PC
                                    int baseChoice = u.askInt();

                                    switch (baseChoice) {
                                        case 1: // Base ufficio
                                            hasBase = true;
                                            controller.createBaseComputer(1);
                                            view.println("Hai scelto la base Ufficio.");
                                            break;

                                        case 2: // Base gaming
                                            hasBase = true;
                                            controller.createBaseComputer(2);
                                            view.println("Hai scelto la base Gaming.");
                                            break;

                                        case 0: // torna al menu precedente
                                            view.println("Tornando indietro...");
                                            break;

                                        default: // input non valido
                                            view.println("Scelta non valida.");
                                    }
                                } while (!hasBase && subChoice != 0); // ripeti finché non viene scelta una base o si torna indietro
                            }

                        } else {
                            // Menu completo dopo scelta base
                            switch (subChoice) {
                                case 1: // Riepilogo configurazione
                                    controller.showSummary();
                                    break;

                                case 2: // Aggiungi componente
                                    boolean adding = true;
                                    while (adding) {
                                        view.chooseComponentMenu();  // menu con RAM, SSD, GPU, etc.
                                        int compChoice = u.askInt();
                                        switch (compChoice) {
                                            case 1, 2, 3, 4:
                                                controller.addComponent(compChoice); // aggiunge il componente scelto
                                                view.println("Componente aggiunto!");
                                                break;

                                            case 0: // torna al menu precedente
                                                adding = false;
                                                view.println("Tornando al menu precedente...");
                                                break;

                                            default:
                                                view.println("Scelta non valida.");
                                        }
                                    }
                                    break;

                                case 3: // Rimuovi componente
                                // TODO - Da implementare qui, sul controller e sul facade.
                                // Dovrebbe mostrare solo i componenti attualmente aggiunti e permettere di rimuoverli uno alla volta.
                                    boolean removing = true;
                                    while (removing) {
                                        controller.showComponents(); // mostra componenti attuali

                                        view.println("Scegli componente da rimuovere (0 per uscire):");
                                        int removeChoice = u.askInt();
                                        switch (removeChoice) {
                                            case 1, 2, 3, 4:
                                                
                                                break;

                                            case 0:
                                                removing = false; // esce dal menu rimozione
                                                break;

                                            default:
                                                view.println("Scelta non valida.");
                                        }
                                    }
                                    break;
                                
                                // TODO - Aggiungere il case 4 per impostare la priorità di consegna

                                case 9: // Conferma configurazione e pagamento 
                                // TODO - Mostrare riepilogo prima di confermare, chiedere conferma, etc. e tornare al menu principale dopo il pagamento
                                    boolean choosingPayment = true;

                                    while (choosingPayment) {
                                        view.choosePaymentMenu(); // menu pagamento
                                        int payChoice = u.askInt();

                                        switch (payChoice) {
                                            case 1, 2, 3: // Carta, PayPal, Bonifico
                                                controller.choosePayment(payChoice); // selezione strategia pagamento
                                                controller.confirmOrder();           // conferma ordine e applica pagamento
                                                choosingPayment = false;
                                                break;

                                            case 0:
                                                choosingPayment = false; // torna indietro senza pagare
                                                break;

                                            default:
                                                view.println("Scelta non valida.");
                                        }
                                    }
                                    break;

                                case 0: // torna al menu principale
                                    view.println("Tornando al menu principale...");
                                    hasBase = false; // reset della configurazione
                                    break;

                                default:
                                    view.println("Scelta non valida.");
                            }
                        }

                    } while (subChoice != 0); // ripete il menu configurazione finché non si torna indietro
                    break;

                case 0: // Esci dal programma
                    view.println("Uscita in corso...");
                    break;

                default:
                    view.println("Scelta non valida.");
            }

        } while (choice != 0); // ciclo principale finché non esce

        view.println("Grazie per aver utilizzato il Pc Configuration Manager.\nArrivederci!");
    }
}