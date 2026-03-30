import java.sql.*;
import java.util.Scanner;

public class App {

    static String url = "jdbc:mysql://localhost:3306/sakila";
    static String user = "root";
    static String psw = "root";

    public static void main(String[] args) {

        // CREATE
        createFilm("Nuovo Film", "Descrizione test", 2026, 1);
        createFilm("Nuovo Film2", "Descrizione test2", 2026, 2);

        // READ
        readFilms(5);

        // UPDATE
        updateFilmTitle(1, "Nuovo Titolo");

        // DELETE
        deleteFilm(12);
        deleteByName();

        // READ
        readFilms(5);

        // FIND
        findByName();

    }

    // DELETE BY TITLE
    public static void deleteByName(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Chiedi input (titolo)
        System.out.print("Inserisci una stringa da cercare nel titolo: ");
        String keyword = scanner.nextLine();

        String query = "DELETE FROM film WHERE title LIKE ?";

        try (Connection conn = DriverManager.getConnection(url, user, psw);
            PreparedStatement ps = conn.prepareStatement(query)) {

            // Inseriamo il parametro con % per il LIKE
            ps.setString(1, "%" + keyword + "%");

            ps.executeUpdate();

            System.out.println("Film rimossi!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // FIND BY TITLE
    public static void findByName(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Chiedi input (titolo)
        System.out.print("Inserisci una stringa da cercare nel titolo: ");
        String keyword = scanner.nextLine();

        String query = "SELECT title, description, release_year FROM film WHERE title LIKE ?";

        try (Connection conn = DriverManager.getConnection(url, user, psw);
            PreparedStatement ps = conn.prepareStatement(query)) {

            // Inseriamo il parametro con % per il LIKE
            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println("\nRisultati della ricerca:");

            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                int year = rs.getInt("release_year");

                System.out.println("Titolo: " + title);
                System.out.println("Descrizione: " + description);
                System.out.println("Anno di rilascio: " + year);
                System.out.println("---------------------------");
                found = true;
            }

            if (!found) {
                System.out.println("Nessun film trovato contenente \"" + keyword + "\".");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // CREATE
    public static void createFilm(String title, String description, int year, int language) {
        String query = "INSERT INTO film (title, description, release_year, language_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setInt(3, year);
            pstmt.setInt(4, language);

            pstmt.executeUpdate();
            System.out.println("Film inserito");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void readFilms(int limit) {
        String query = "SELECT film_id, title, release_year FROM film LIMIT ?";

        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setInt(1, limit);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("film_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getInt("release_year")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateFilmTitle(int id, String newTitle) {
        String query = "UPDATE film SET title = ? WHERE film_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, newTitle);
            pstmt.setInt(2, id);

            pstmt.executeUpdate();
            System.out.println("Film aggiornato");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteFilm(int id) {
        String query = "DELETE FROM film WHERE film_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            System.out.println("Film rimosso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}