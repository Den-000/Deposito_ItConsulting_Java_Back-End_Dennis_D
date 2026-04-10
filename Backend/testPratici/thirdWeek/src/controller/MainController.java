package controller;

import controller.facade.AuthFacade;
import model.accountModel.*;
import view.MainView;
import view.UserView;
import view.utility.Utility;

public abstract class MainController {

    protected AuthFacade authFacade = new AuthFacade();

    public Account handleLoginMenu(int choice, MainView view, Account account) {

        switch (choice) {

            case 1 -> { // LOGIN

                view.print("Email: ");
                String email = Utility.askString();

                view.print("Password: ");
                String password = Utility.askString();

                Account result = authFacade.login(email, password);

                if (result != null) {
                    account = result;
                    view.println("Login effettuato!");
                } else {
                    view.println("Credenziali errate!");
                }
            }

            case 2 -> { // REGISTER

                view.print("Username: ");
                String username = Utility.askString();

                view.print("Email: ");
                String email = Utility.askString();

                view.print("Password: ");
                String password = Utility.askString();

                authFacade.register(username, email, password);

                view.println("Registrazione completata!");
            }

            default -> view.println("Scelta non valida");
        }

        return account;
    }

    // VIEW ADAPTATION (migliorabile ma ok per ora)
    public MainView adaptView(Account account) {

        if (account instanceof Admin) {
            // return new AdminView();
        }

        return new UserView();
    }

    // CONTROLLER ADAPTATION
    public MainController adaptController(Account account) {

        if (account instanceof Admin) {
            // return new AdminController();
        }

        return new UserController();
    }

    public abstract void handleMainMenuChoice(int choice, MainView view);
}