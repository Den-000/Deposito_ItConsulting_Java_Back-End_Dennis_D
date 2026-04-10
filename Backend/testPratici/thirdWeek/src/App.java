import controller.MainController;
import controller.UserController;
import model.accountModel.Account;
import view.MainView;
import view.UserView;
import view.utility.Utility;

public class App {
    public static void main(String[] args) {

        MainView view = new UserView();
        MainController controller = new UserController();

        Account account = null;
        int choice;

        do {
            // Mostra il menu di login finché l'utente non effettua il login o sceglie di uscire
            view.showLoginMenu();
            choice = Utility.askInt();

            // Gestisce la scelta del menu di login. Se l'utente sceglie di effettuare il login o di registrarsi, viene restituito un account valido.
            if (choice != 0) {
                account = controller.handleLoginMenu(choice, view, account);
            }

            // Se l'account è valido, mostra il menu principale e gestisce le scelte finché l'utente non sceglie di uscire
            if (account != null) {

                // Adatta view e controller in base al tipo di account
                view = controller.adaptView(account);
                controller = controller.adaptController(account);

                int mainChoice;

                do {
                    // Mostra il menu principale e gestisce la scelta dell'utente
                    view.showMainMenu();
                    mainChoice = Utility.askInt();

                    // Gestisce la scelta del menu principale in base al tipo di account. Se l'utente sceglie di uscire, torna al menu di login.
                    controller.handleMainMenuChoice(mainChoice, view);

                } while (mainChoice != 0);
            }

        } while (choice != 0);
    }
}