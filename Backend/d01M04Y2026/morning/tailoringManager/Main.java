package tailoringManager;

import tailoringManager.controller.TailoringController;
import tailoringManager.service.TailoringService;
import tailoringManager.view.TailoringView;

// ===== AVVIO PROGRAMMA =====
public class Main {
    public static void main(String[] args) {

        // Oggetto con metodi per gestire la logica dell'applicazione
        TailoringService service = new TailoringService();

        // Oggetto con metodi per gestire l'interfaccia utente
        TailoringView view = new TailoringView();

        // Oggetto con metodi per gestire l'interazione tra logica e interfaccia
        TailoringController controller = new TailoringController(service, view);

        controller.runApp();
    }
}

/* Migliorie da apportare:
    - Aggiungere commenti più dettagliati per ogni classe e metodo, spiegando il loro scopo e funzionamento
    - Aggiungere validazione più robusta
    - Modificare il metodo showDetails() per restituire una stringa più dettagliata e formattata, AL MOMENTO NON MOSTRA IL "CODE"
    - Aggiungere tutti i getter e setter mancanti nelle classi, ove mancanti e necessari
    - Implementare un sistema di salvataggio su file o su db per mantenere i dati tra le esecuzioni
    - Strutturare una suddivisione più netta del codice (es. creare classi separate per i menu e le operazioni sui dati)
*/