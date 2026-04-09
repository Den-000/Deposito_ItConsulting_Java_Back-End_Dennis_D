import java.util.ArrayList;
import java.util.List;
import controller.OrderController;
import model.Order;
import view.View;
import utility.Utility;

public class App {
    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();       // Lista ordini
        OrderController controller = new OrderController(orders); // Controller

        int choice;
        
        do {
            View.displayMenu();              // Mostra menu
            View.print("Scelta: ");
            choice = Utility.askInt();       // Input scelta

            switch (choice) {
                case 1 -> controller.createOrder();
                case 2 -> controller.showOrders();
                case 3 -> controller.changeOrderState();
                case 4 -> controller.removeOrder();
                case 0 -> View.println("Uscita in corso...");
                default -> View.println("Scelta non valida!");
            }

        } while (choice != 0); // Loop fino ad uscita
    }
}