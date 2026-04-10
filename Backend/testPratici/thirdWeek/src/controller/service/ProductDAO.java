package controller.service;

import model.factory.productFactory.*;
import model.productModel.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements ICrud<Product> {

    // CREATE
    public void create(Product product) {
        String sql = "INSERT INTO products (name, description, price, category, stock) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setFloat(3, product.getPrice());
            stmt.setString(4, product.getCategory());
            stmt.setInt(5, product.getStock());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // FIND BY ID
    public Product findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractProduct(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // FIND BY NAME
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                products.add(extractProduct(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // FIND BY CATEGORY
    public List<Product> findByCategory(String category) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE category = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                products.add(extractProduct(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // UPDATE
    public void update(int id, Product product) {
        String sql = "UPDATE products SET name = ?, description = ?, price = ?, category = ?, stock = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setFloat(3, product.getPrice());
            stmt.setString(4, product.getCategory());
            stmt.setInt(5, product.getStock());
            stmt.setInt(6, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // FIND ALL
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                products.add(extractProduct(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // Metodo per estrarre un oggetto Product da un ResultSet
    private Product extractProduct(ResultSet rs) throws SQLException {

        String category = rs.getString("category");

        ProductFactory factory = null;

        if ("ELECTRONICS".equalsIgnoreCase(category)) {
            factory = new ElectronicFactory();
        } else if ("CLOTHING".equalsIgnoreCase(category)) {
            factory = new ClothingFactory();
        } else if ("HOME".equalsIgnoreCase(category)) {
            factory = new HomeFactory(); 
        }
        return factory.createProduct(
                rs.getString("name"),
                rs.getString("description"),
                rs.getFloat("price"),
                rs.getInt("stock")
        );
    }

}