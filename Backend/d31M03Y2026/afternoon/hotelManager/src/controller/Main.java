package d31M03Y2026.afternoon.hotelManager.src.controller;

import d31M03Y2026.afternoon.hotelManager.src.model.*;
import d31M03Y2026.afternoon.hotelManager.src.utility.Utility;
import d31M03Y2026.afternoon.hotelManager.src.view.*;

public class Main {

    // Al momento viene aggiornato solo il db, gli oggetti Hotel e Room rimangono a morire nell'etere della heap memory
    // Aggiungere check sugli input prima di salvare nel DB
    // Aggiungere casistica → Hotel non presente
    public static void main(String[] args) {

        HotelController controller = new HotelController();
        View view = new View();

        int choice;

        do {
            view.showMenu();

            view.println("Scelta: ");
            choice = Utility.askInt();

            switch (choice) {

                case 1: // Aggiungi hotel
                    view.println("Nome hotel: ");
                    String name = Utility.askString();

                    Hotel tempHotel = new Hotel(name);
                    controller.createHotel(tempHotel.getName());
                    break;

                case 2: // Mostra Hotels
                    controller.listHotels();
                    break;

                case 3: // Aggiungi stanza ad hotel
                    controller.listHotels();
                    addRoom();
                    break;

                case 4: // Aggiungi Suite ad hotel
                    controller.listHotels();
                    addSuite();
                    break;

                case 5: // Mostrare stanze di un hotel
                    controller.listHotels();
                    view.println("ID hotel: ");
                    controller.showRooms(Utility.askInt());
                    break;
            }

        } while (choice != 0);   
    }

    private static void addRoom() {
        HotelController controller = new HotelController();
        View view = new View();

        view.println("ID hotel: ");
        int id = Utility.askInt();

        view.println("Numero: ");
        int number = Utility.askInt();

        view.println("Prezzo: ");
        float price = Utility.askFloat();

        Hotel tempHotel = controller.getHotelById(id);
        Room tempRoom = new Room(number, price);
        tempHotel.addRoom(tempRoom);
        controller.addStandardRoom(id, tempRoom.getNumber(), tempRoom.getPrice());
    }

    private static void addSuite() {
        HotelController controller = new HotelController();
        View view = new View();
        
        view.println("ID hotel: ");
        int id = Utility.askInt();

        view.println("Numero: ");
        int number = Utility.askInt();

        view.println("Prezzo: ");
        float price = Utility.askFloat();

        view.println("Servizi: ");
        String services = Utility.askString();

        Hotel tempHotel = controller.getHotelById(id);
        Suite tempSuite = new Suite(number, price, services);
        tempHotel.addRoom(tempSuite);

        controller.addSuite(id, number, price, services);
    }

}