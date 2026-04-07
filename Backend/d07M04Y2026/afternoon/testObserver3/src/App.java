import controller.OrderController;
import utility.Utility;
import view.OrderView;

public class App {
    public static void main(String[] args) throws Exception {

        // Istanza del controller (logica applicativa)
        OrderController controller = new OrderController();

        // Istanza della view (gestione output)
        OrderView view = new OrderView();

        // Loop infinito per il menu
        while (true) {

            // Mostra il menu all'utente
            view.showMenu();

            // Richiede la scelta
            view.print("Scelta: ");

            // Legge un intero tramite utility (con validazione)
            int choice = Utility.askInt();

            // Gestione delle scelte tramite switch
            switch (choice) {

                // Inserimento di un nuovo ordine
                case 1 -> controller.insert();

                // Visualizzazione di tutti gli ordini
                case 2 -> controller.showAll();

                // Ricerca di un ordine per ID
                case 3 -> {
                    System.out.print("ID: ");
                    controller.findById(Utility.askInt());
                }

                // Aggiornamento dello stato di un ordine
                case 4 -> controller.modifyOrderState();

                // Uscita dal programma
                case 0 -> {
                    System.out.println("Uscita...");
                    return; // termina il programma
                }

                // Caso default: input non valido
                default -> System.out.println("Scelta non valida");
            }
        }
    }
}