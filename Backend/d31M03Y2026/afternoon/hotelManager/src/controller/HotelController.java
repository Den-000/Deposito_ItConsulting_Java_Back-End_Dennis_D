package d31M03Y2026.afternoon.hotelManager.src.controller;

import java.sql.*;
import java.util.*;
import d31M03Y2026.afternoon.hotelManager.src.model.*;

public class HotelController {

    // =========================
    // HOTEL
    // =========================

    public void createHotel(String name) {
        String query = "INSERT INTO hotel(name) VALUES(?)";

        try (Connection conn = DBConnection.getConnection(); // DriverManager.getConnection(URL, USER, PASSWORD)
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.executeUpdate();

            System.out.println("Hotel creato con successo");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listHotels() {
        String query = "SELECT * FROM hotel";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n=== LISTA HOTEL ===");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + ") " +
                        rs.getString("name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Hotel getHotelById(int id){
        String query = "SELECT * FROM hotel WHERE id = ?";
        Hotel tempHotel = new Hotel();

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                tempHotel.setName(rs.getString("name"));
                tempHotel.setRooms(getRooms(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempHotel;
    }

    // =========================
    // CAMERE
    // =========================

    public void addStandardRoom(int hotelId, int number, float price) {

        String query = "INSERT INTO room(number, price, type, hotel_id) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, number);
            stmt.setFloat(2, price);
            stmt.setString(3, "standard");
            stmt.setInt(4, hotelId);

            stmt.executeUpdate();

            System.out.println("Camera aggiunta");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSuite(int hotelId, int number, float price, String services) {

        String query = "INSERT INTO room(number, price, type, extra_services, hotel_id) VALUES(?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, number);
            stmt.setFloat(2, price);
            stmt.setString(3, "suite");
            stmt.setString(4, services);
            stmt.setInt(5, hotelId);

            stmt.executeUpdate();

            System.out.println("Suite aggiunta");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Room> getRooms(int hotelId) {

        ArrayList<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM room WHERE hotel_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, hotelId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String type = rs.getString("type");

                if ("suite".equals(type)) {
                    rooms.add(new Suite(
                            rs.getInt("number"),
                            rs.getFloat("price"),
                            rs.getString("extra_services")
                    ));
                } else {
                    rooms.add(new Room(
                            rs.getInt("number"),
                            rs.getFloat("price")
                    ));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rooms;
    }

    public void showRooms(int hotelId) {

        List<Room> rooms = getRooms(hotelId);

        System.out.println("\n=== CAMERE HOTEL ===");

        for (Room r : rooms) {
            r.roomDetails(true); // uso overload
        }

        System.out.println("Numero suite: " +
                Hotel.countSuites(new ArrayList<Room>(rooms)));
    }
}