package dao;

import java.sql.*;
import java.util.*;

import model.Order;

public class OrderManager {

    private Connection conn;

    // Costruttore → ottiene connessione e crea tabella
    public OrderManager() throws SQLException {
        conn = DBConnection.getInstance().getConnection();
        createTable();
    }

    // Crea la tabella se non esiste
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS orders (" +
                "id INTEGER PRIMARY KEY, " +
                "customer TEXT, " +
                "product TEXT, " +
                "quantity INTEGER, " +
                "state TEXT)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Inserisce un ordine nel DB
    public void insertOrder(Order o) {
        String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, o.getId());
            ps.setString(2, o.getCustomer());
            ps.setString(3, o.getProduct());
            ps.setInt(4, o.getQuantity());
            ps.setString(5, o.getState());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Restituisce tutti gli ordini
    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        try (Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Order(
                        rs.getInt("id"),
                        rs.getString("customer"),
                        rs.getString("product"),
                        rs.getInt("quantity"),
                        rs.getString("state")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Cerca un ordine per ID
    public Order getOrderById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Order(
                        rs.getInt("id"),
                        rs.getString("customer"),
                        rs.getString("product"),
                        rs.getInt("quantity"),
                        rs.getString("state")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Aggiorna lo stato di un ordine
    public void modifyOrderState(int id, String state) {
        String sql = "UPDATE orders SET state = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, state);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}