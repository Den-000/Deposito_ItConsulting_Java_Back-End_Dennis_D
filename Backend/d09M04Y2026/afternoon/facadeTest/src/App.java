import facade.LightsManager;
import utility.Utility;
import view.View;

public class App {
    public static void main(String[] args) throws Exception {
        View view = new View();
        LightsManager lightsManager = new LightsManager();

        int choice;
        do {
            view.displayMenu();
            choice = Utility.askInt();

            switch (choice) {
                case 1:
                    lightsManager.turnOnAllLights();
                    break;
                case 2:
                    lightsManager.turnOnKitchenLight();
                    break;
                case 3: 
                    lightsManager.turnOnLivingRoomLight();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }
}
