package d31M03Y2026.afternoon.hotelManager.src.model;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    public String getName() { return name;}
    public void setName(String name) {this.name = name;}

    public ArrayList<Room> getRooms() {return rooms;}
    public void setRooms(ArrayList<Room> rooms) {this.rooms = rooms;}

    // Costruttori
    public Hotel() {
        this.rooms = new ArrayList<>();
    }
    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
    }
    public Hotel(String name, ArrayList<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    // Aggiunta camera
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Metodo statico
    public static int countSuites(ArrayList<Room> list) {
        int count = 0;
        for (Room r : list) {
            if (r instanceof Suite) count++;
        }
        return count;
    }
}