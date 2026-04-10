import controller.MainController;
import controller.UserController;
import model.accountModel.*;
import view.MainView;
import view.UserView;
import view.utility.Utility;

public class App {
    public static void main(String[] args) throws Exception {
        
        MainView view = new UserView();
        MainController controller = new UserController();

        // Ciclo do while per il log in
        int choice;
        Account account = null;
        do {
            view.showLoginMenu();
            choice = Utility.askInt();

            // Se l'utente sceglie di fare il login o la registrazione, gestisco la scelta
            if (choice != 0) {
                account = controller.handleLoginMenu(choice);
            }

            // Se il login è stato effettuato con successo, avvia il flusso dell'applicazione a seconda del tipo di account
            if (account != null) {
                controller.adaptView(account, view); // Istanzia la view a seconda del tipo di account
                // controller.adaptController(account, controller); // Adatta il controller a seconda del tipo di account

                int mainChoice;
                // Ciclo do while per il menu principale
                do {
                    view.showMainMenu();
                    mainChoice = Utility.askInt();

                    // Come per la view, anche la gestione del menu principale dipende dal tipo di account
                    // controller.handleMainMenuChoice(account, mainChoice); // Gestisce la scelta del menu principale a seconda del tipo di account

                } while (mainChoice != 0);
            }

        } while (choice != 0);
    }
}
