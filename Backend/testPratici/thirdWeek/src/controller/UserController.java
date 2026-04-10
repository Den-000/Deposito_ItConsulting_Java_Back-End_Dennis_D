package controller;

import java.util.List;

import controller.service.ProductDAO;
import model.productModel.Product;
import view.MainView;

public class UserController extends MainController {

    public void handleMainMenuChoice(int choice, UserView view) {

        switch (choice) {

            case 1 -> {// Apri catalogo prodotti → Visualizza tutti o filtra
                view.openCatalogueMenu();
                ProductDAO productDAO = new ProductDAO();
                List<Product> products = productDAO.findAll();
                view.println("\n===== Prodotti =====");
                for (Product p : products) {
                        p.toString();
                }
                    view.println("====================");
                }
            case 2 -> // Implementa la logica per visualizzare gli ordini dell'utente
                    view.println("Visualizza ordini");
            case 3 -> // TODO: implementa la logica per visualizzare il carrello dell'utente
                    view.println("Visualizza carrello");
            case 4 -> // TODO: implementa la logica per visualizzare gli ordini dell'utente
                    view.println("Visualizza ordini");
            case 5 -> // TODO: implementa la logica per visualizzare e modificare le impostazioni dell'account dell'utente
                    view.println("Impostazioni account");
            case 0 -> view.println("Logout");

            default -> view.println("Scelta non valida");
        }
    }

    // Mostra tutti i prodotti disponibili

}