import java.sql.SQLException;

import controller.AppController;
import view.ConsoleView;

public class App {
   public static void main(String[] args) throws SQLException {
        ConsoleView view = new ConsoleView();
        AppController controller = new AppController(view);
        controller.login();
    }
}
