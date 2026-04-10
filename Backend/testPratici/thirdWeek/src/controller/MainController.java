package controller;

import controller.service.AccountDAO;
import model.accountModel.Account;
import model.factory.accountFactory.AccountFactory;
import model.factory.accountFactory.AdminFactory;
import model.factory.accountFactory.UserFactory;
import view.MainView;
import view.UserView;
import view.utility.Utility;

public abstract class MainController {

    private AccountDAO accountDAO = new AccountDAO();

    public Account handleLoginMenu(int choice) {
        MainView view = new UserView();
        AccountFactory accountFactory = new UserFactory();

        Account account = null;

        switch (choice) {

            case 1: // LOGIN
                view.print("Email: ");
                String email = Utility.askString();

                view.print("Password: ");
                String password = Utility.askString();

                Account accountFound = accountDAO.findByEmail(email);

                if (accountFound != null && accountFound.getPassword().equals(password)) {
                    view.println("Login effettuato!");
                    account = accountFound;
                } else {
                    view.println("Credenziali errate!");
                }
                break;

            case 2: // REGISTRAZIONE
                view.print("Username: ");
                String newUsername = Utility.askString();

                view.print("Email: ");
                String newEmail = Utility.askString();

                view.print("Password: ");
                String newPassword = Utility.askString();

                Account newAccount = accountFactory.createAccount(
                        newUsername,
                        newEmail,
                        newPassword
                );

                // Salva nel DB
                accountDAO.create(newAccount);

                view.println("Registrazione completata! Ora puoi effettuare il login.");
                break;

            default:
                view.println("Scelta non valida.");
        }

        return account;
    }

    // Metodo per mostrare il menu principale in base al tipo di account
    public void adaptView(Account account, MainView view) {
        if (account instanceof AdminFactory) {
            // view = new AdminView();
        }
        else {
            view = new UserView();
        }

    }

    public void adaptController(Account account, MainController controller) {
        if (account instanceof AdminFactory) {
            // controller = new AdminController();
        }
        else {
            controller = new UserController();
        }
    }
}