package controller.service;

import model.accountModel.Account;
import model.factory.accountFactory.AccountFactory;
import model.factory.accountFactory.AdminFactory;
import model.factory.accountFactory.UserFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements ICrud<Account> {

    // CREATE
    public void create(Account account) {
        String sql = "INSERT INTO accounts (username, email, password, role) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getEmail());
            stmt.setString(3, account.getPassword());
            stmt.setString(4, account.getRole());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CERCA PER ID
    public Account findById(int id) {
        String sql = "SELECT * FROM accounts WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractAccount(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // CERCA PER USERNAME
    public Account findByUsername(String username) {
        String sql = "SELECT * FROM accounts WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractAccount(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // CERCA PER EMAIL
    public Account findByEmail(String email) {
        String sql = "SELECT * FROM accounts WHERE email = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractAccount(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // CERCA PER RUOLO
    public List<Account> findByRole(String role) {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM accounts WHERE role = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, role);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                accounts.add(extractAccount(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    // UPDATE
    // TODO: Permettere di aggiornare solo alcuni campi (es. email e password) o tutti
    public void update(int id, Account account) {
        String sql = "UPDATE accounts SET username = ?, email = ?, password = ?, role = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getEmail());
            stmt.setString(3, account.getPassword());
            stmt.setString(4, account.getRole());
            stmt.setInt(5, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM accounts WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // FIND ALL
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM accounts";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                accounts.add(extractAccount(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    // Metodo per estrarre un oggetto Account da un ResultSet
    private Account extractAccount(ResultSet rs) throws SQLException {

    String role = rs.getString("role");

    AccountFactory factory;

    if ("ADMIN".equalsIgnoreCase(role)) {
        factory = new AdminFactory();
    } else {
        factory = new UserFactory();
    }

    return factory.createAccount(
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
    );
}
}