package controller;

import dao.UserManager;
import model.User;
import utility.Utility;
import view.ConsoleView;

public class AppController {

    User user;
    UserManager userManager;
    private ConsoleView view;

    public AppController(ConsoleView view) {
        this.view = view;
        this.userManager = new UserManager();
    }

    // Metodo per gestire il processo di login e/o registrazione
    public void login() {
        boolean running = true;

        while (running) {
            view.showLogin();
            view.print("Scegli un'opzione: ");
            int choice = Utility.askInt();

            switch (choice) {
                case 1: // Login
                    view.print("Username: ");
                    String username = Utility.askString();

                    view.print("\nPassword: ");
                    String password = Utility.askString();

                    if (userManager.login(username, password)) {
                        view.println("Login riuscito!");
                        user = new User(username, password);
                        run();
                    } else {
                        view.println("Credenziali non valide. Riprova.");
                    }
                    break;

                case 2: // Registrazione
                    view.print("Scegli un username: ");
                    String newUsername = Utility.askString();

                    view.print("\nScegli una password: ");
                    String newPassword = Utility.askString();

                    if (userManager.createUser(newUsername, newPassword)) {
                        view.println("Registrazione riuscita! Ora puoi effettuare il login.");
                    } else {
                        view.println("Registrazione fallita. Riprova.");
                    }
                    break;
                case 0:
                    view.println("Uscita in corso...");
                    return;
                default:
                    view.println("Scelta non valida!");
            }
        }
    }

    // Metodo per gestire il menu principale dopo il login
    public void run() {
        boolean running = true;

        // Il menu principale rimane attivo finché l'utente non sceglie di effettuare il logout o di eliminare il profilo
        while (running) {
            view.showMainMenu();
            view.print("Scegli un'opzione: ");
            int choice = Utility.askInt();

            // Gestione dell'eliminazione del profilo
            if (choice == 4) {
                if (userManager.deleteUser(user.getUsername())) {
                    user = null;
                    view.println("Profilo eliminato con successo!");
                    return;
                } else {
                    view.println("Errore durante l'eliminazione del profilo. Riprova.");
                    break;
                }
            }

            // Gestione delle altre opzioni del menu
            switch (choice) {
                case 1: // Visualizza profilo
                     view.println("Profilo utente:");
                     view.println("Username: " + user.getUsername());
                     view.println("Password: " + user.getPassword());
                    break;
                case 2: // Aggiorna username
                    view.print("Nuovo username: ");
                    String newUsername = Utility.askString();

                    if (userManager.updateUserUsername(user.getUsername(), newUsername)) {
                        view.println("Username aggiornato con successo!");
                        user.setUsername(newUsername);
                    } else {
                        view.println("Errore durante l'aggiornamento dell'username. Riprova.");
                    }
                    break;
                case 3: // Aggiorna password
                    view.print("Nuova password: ");
                    String newPassword = Utility.askString();

                    if (userManager.updateUserPassword(user.getUsername(), newPassword)) {
                        view.println("Password aggiornata con successo!");
                        user.setPassword(newPassword);
                    } else {
                        view.println("Errore durante l'aggiornamento della password. Riprova.");
                    }
                    break;
                case 0: // Logout
                        view.println("Logout in corso...");
                    return;
                default:
                    view.println("Scelta non valida!");
            }
        }
    }
}