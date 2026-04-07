import controller.AppController;
import view.ConsoleView;

public class App {
    public static void main(String[] args) {

        ConsoleView view = new ConsoleView();
        AppController controller = new AppController();

        view.showMsg("Applicazione avviata");

        // Uso tramite controller
        controller.executeOperation();
    }
}