import controller.ComputerController;
import model.ComputerFacade;
import view.ComputerView;

public class App {

    public static void main(String[] args) {

        ComputerFacade facade = new ComputerFacade();
        ComputerView view = new ComputerView();

        ComputerController controller = new ComputerController(facade, view);

        controller.accendiComputer();
    }
}