import java.sql.*;
import java.util.Scanner;

public class App {

    static String url = "jdbc:mysql://localhost:3306/school_itconsulting";
    static String user = "root";
    static String psw = "root";


    /* FIX DA FARE:
        - Forse invertire numero delel opzioni per Inserisci ed Inserisci voto, poichè la seconda dovrebbe essere più utilizzata della prima

        - Aggiunte da fare nella voce Elimina:
                                    - Aggiungere opzione e funzione per svuotare una classe 
                                        (es. Dopo 1 anno gli alunni della 1°A cambieranno, ma la classe rimarrà quella)
                                    - Aggiungere opzione e funzione per eliminare tutti i voti associati ad uno studente 
                                        (es. Dopo 1 anno, i voti andranno rimossi per far spazio a quelli dell'anno nuovo)

        
        - Quando si inserisce un voto, stampare e richiedere prima la classe, poi stampare la lista di studenti di quella classe e chiedere l'id dello studente

        - Riga 356 → Commento con Fix da fare alla view:
                                        - Aggiungere la stampa di tutti gli studenti per classe
                                        - Aggiungere la stampa degli studenti di 1 classe
                                        - Modificare l'output della stampa di  1 studente → Dettagli scritti nel commento della funzione
        
    */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu principale
        while (true) {
            System.out.println("\n=== Gestionale Scolastico ===");
            System.out.println("1) Inserisci");
            System.out.println("2) Inserisci voto");
            System.out.println("3) Visualizza");
            System.out.println("4) Modifica");
            System.out.println("5) Elimina");
            System.out.println("0) Esci");
            System.out.println("=============================");

            int choice;
            while (true) {
                System.out.print("Scelta: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice >= 0 && choice <= 5) break;
                    else System.out.println("Scelta non valida (0-5)");
                } else {
                    System.out.println("Inserisci un numero!");
                    scanner.nextLine();
                }
            }

            switch (choice) {
                case 1 -> addMenu(scanner);
                case 2 -> addVote(scanner);
                case 3 -> viewMenu(scanner);
                case 4 -> modifyMenu(scanner);
                case 5 -> removeMenu(scanner);
                case 0 -> {
                    System.out.println("Arrivederci!");
                    return;
                }
            }
        }
    }

    // ==================== EXISTS ====================
    // Controlla se il record esiste/è presente
    public static boolean exists(String table, int id) {
        String query = "SELECT id FROM " + table + " WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ==================== MENU ====================
    // Menu per gli inserimenti
    public static void addMenu(Scanner scanner) {
        System.out.println("\n=== Menu Inserimenti ===");
        System.out.println("1) Studente");
        System.out.println("2) Classe");
        System.out.println("3) Materia");
        System.out.println("0) Indietro");
        System.out.println("========================");

        int choice;
        // Loop con controllo
        while (true) {
            System.out.print("Scelta: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 0 && choice <= 3) break;
                else System.out.println("Scelta non valida");
            } else {
                System.out.println("Inserisci un numero!");
                scanner.nextLine();
            }
        }

        switch (choice) {
            case 1 -> addStudent(scanner);
            case 2 -> addClass(scanner);
            case 3 -> addSubject(scanner);
        }
    }

    // Menu per le stampe/visualizzazioni
    public static void viewMenu(Scanner scanner) {
        System.out.println("\n=== Menu Visualizza ===");
        System.out.println("1) Studente");
        System.out.println("2) Voto");
        System.out.println("3) Classe");
        System.out.println("4) Materia");
        System.out.println("0) Indietro");
        System.out.println("=======================");

        int choice;
        // Loop con controllo
        while (true) {
            System.out.print("Scelta: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 0 && choice <= 4) break;
                else System.out.println("Scelta non valida");
            } else {
                System.out.println("Inserisci un numero!");
                scanner.nextLine();
            }
        }

        switch (choice) {
            case 1 -> viewStudent(scanner);
            case 2 -> viewVotes();
            case 3 -> viewClasses();
            case 4 -> viewSubjects();
        }
    }
    
    // Menu per modifiche
    public static void modifyMenu(Scanner scanner) {
        System.out.println("\n=== Menu Modifica ===");
        System.out.println("1) Studente");
        System.out.println("2) Voto");
        System.out.println("3) Classe");
        System.out.println("4) Materia");
        System.out.println("0) Indietro");
        System.out.println("=====================");

        int choice;
        // Loop con controllo
        while (true) {
            System.out.print("Scelta: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 0 && choice <= 4) break;
                else System.out.println("Scelta non valida");
            } else {
                System.out.println("Inserisci un numero!");
                scanner.nextLine();
            }
        }

        switch (choice) {
            case 1 -> modifyStudent(scanner);
            case 2 -> modifyVote(scanner);
            case 3 -> modifyClass(scanner);
            case 4 -> modifySubject(scanner);
        }
    }

    // Menu per rimozione
    public static void removeMenu(Scanner scanner) {
        System.out.println("\n=== Menu Rimozione ===");
        System.out.println("1) Studente");
        System.out.println("2) Voto");
        System.out.println("3) Classe");
        System.out.println("4) Materia");
        System.out.println("0) Indietro");
        System.out.println("======================");

        int choice;
        // Loop con controllo
        while (true) {
            System.out.print("Scelta: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 0 && choice <= 4) break;
                else System.out.println("Scelta non valida");
            } else {
                System.out.println("Inserisci un numero!");
                scanner.nextLine();
            }
        }

        switch (choice) {
            case 1 -> removeStudent(scanner);
            case 2 -> removeVote(scanner);
            case 3 -> removeClass(scanner);
            case 4 -> removeSubject(scanner);
        }
    }

    // ==================== ADD ====================
    // Funzione aggiungi studente (a classe)
    public static void addStudent(Scanner scanner) {
        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Cognome: ");
        String surname = scanner.nextLine();

        System.out.println("\nClassi disponibili:");
        viewClasses();
        System.out.println("\n");

        System.out.print("Classe ID: ");
        int classId = scanner.nextInt();
        scanner.nextLine();

        String query = "INSERT INTO Studenti (nome, cognome, classe_id) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setInt(3, classId);
            ps.executeUpdate();

            System.out.println("Studente inserito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione aggiungi classe
    public static void addClass(Scanner scanner) {
        int grade;
        // Controllo sul grado della classe (es. da 1°A a 5°A)
        while (true) {
            System.out.print("Grado (1-5): ");
            if (scanner.hasNextInt()) {
                grade = scanner.nextInt();
                scanner.nextLine();
                if (grade >= 1 && grade <= 5) break;
                else System.out.println("Valore non valido!");
            } else {
                System.out.println("Inserisci numero!");
                scanner.nextLine();
            }
        }

        System.out.print("Sezione: ");
        String section = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(url, user, psw)) {

            // Check se la classe esiste già
            String checkQuery = "SELECT 1 FROM Classi WHERE grado = ? AND sezione = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setInt(1, grade);
                checkStmt.setString(2, section);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Errore: la classe " + grade + "°"+ section + " esiste già!");
                        return;
                    }
                }
            }

            String insertQuery = "INSERT INTO Classi (grado, sezione) VALUES (?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
                ps.setInt(1, grade);
                ps.setString(2, section);
                ps.executeUpdate();
                System.out.println("Classe inserita!");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione aggiungi materia
    public static void addSubject(Scanner scanner) {
        System.out.print("Nome Materia: ");
        String name = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(url, user, psw)) {

            // Check se la classe esiste già
            String checkQuery = "SELECT 1 FROM Materie WHERE nome = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setString(1, name);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Errore: la materia " + name + " esiste già!");
                        return;
                    }
                }
            }

            String insertQuery = "INSERT INTO Materie (nome) VALUES (?)";
            try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {

                ps.setString(1, name);
                ps.executeUpdate();
                System.out.println("Materia inserita!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    // Funzione aggiungi voto (a studente per materia)
    public static void addVote(Scanner scanner) {
        int studentId;
        // Loop con controllo sull'id dello studente (se è presente nel db)
        while (true) {
            System.out.print("ID Studente: ");
            if (scanner.hasNextInt()) {
                studentId = scanner.nextInt();
                scanner.nextLine();
                if (exists("Studenti", studentId)) break;
                else System.out.println("Studente inesistente!");
            } else {
                System.out.println("Numero non valido!");
                scanner.nextLine();
            }
        }

        System.out.println("\nMaterie disponibili:");
        viewSubjects();
        System.out.println("\n");

        int subjectId;
        // Loop con controllo sull'id della materia (se è presente nel db)
        while (true) {
            System.out.print("ID Materia: ");
            if (scanner.hasNextInt()) {
                subjectId = scanner.nextInt();
                if (exists("Materie", subjectId)) break;
                else System.out.println("Materia inesistente!");
            } else {
                System.out.println("Numero non valido!");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        double vote;
        // Loop con controllo sul voto (se è compreso fra 0 e 10, decimali accettati)
        while (true) {
            System.out.print("Voto: ");
            if (scanner.hasNextDouble()) {
                vote = scanner.nextDouble();
                if (vote >= 0 && vote <= 10) break;
                else System.out.println("0-10!");
            } else {
                System.out.println("Numero!");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        String query = "INSERT INTO Voti VALUES (NULL, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, studentId);
            ps.setInt(2, subjectId);
            ps.setDouble(3, vote);
            ps.executeUpdate();
            System.out.println("Voto inserito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==================== VIEW ====================

    // Funzione visualizza/stampa studente (per id) compreso di tutti i voti


    /* FIX DA FARE:
        - Modificare l'output della stampa di  1 studente, dovrà stampare nome cognome e classe solo per la prima iterazione
        - Aggiungere la stampa di tutti gli studenti per classe
        - Aggiungere la stampa degli studenti di 1 classe

        Modificare la voce Studente, aggiungere la voce Studenti con sottomenù con → Visualizza studenti di una classe & Visualizza studenti di tutte le classi
    */

    public static void viewStudent(Scanner scanner) {
        int id;
        // Loop con controllo sull'id studente (se è presente nel db)
        while (true) {
            System.out.print("ID Studente: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (exists("Studenti", id)) break;
                else System.out.println("Studente non esiste!");
            } else {
                scanner.nextLine();
                System.out.println("Numero non valido!");
            }
        }

        String query = """
            SELECT s.nome, s.cognome, c.grado, c.sezione, m.nome AS materia, v.voto
            FROM Studenti s
            JOIN Classi c ON s.classe_id = c.id
            LEFT JOIN Voti v ON s.id = v.studente_id
            LEFT JOIN Materie m ON v.materia_id = m.id
            WHERE s.id = ?;
        """;

        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("nome") + " " + rs.getString("cognome") +
                        " | Classe: " + rs.getInt("grado") + "°" + rs.getString("sezione") +
                        " | Materia: " + rs.getString("materia") +
                        " | Voto: " + rs.getDouble("voto")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione visualizza/stampa voti
    public static void viewVotes() {
        String query = """
            SELECT v.id, s.nome, s.cognome, m.nome AS materia, v.voto
            FROM Voti v
            JOIN Studenti s ON v.studente_id = s.id
            JOIN Materie m ON v.materia_id = m.id
            ORDER BY s.cognome;
        """;

        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ") " + rs.getString("nome") + " " + rs.getString("cognome") +
                        " | " + rs.getString("materia") +
                        " | Voto: " + rs.getDouble("voto")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione visualizza/stampa classi
    public static void viewClasses() {
        String query = "SELECT id, grado, sezione FROM Classi";

        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ") " + rs.getInt("grado") + rs.getString("sezione")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione visualizza/stampa materie
    public static void viewSubjects() {
        String query = "SELECT id, nome FROM Materie";

        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ") " + rs.getString("nome")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==================== MODIFY ====================
    // Funzione modifica studente (per id)
    public static void modifyStudent(Scanner scanner) {
        int id;

        // Loop con controllo id
        while (true) {
            System.out.print("ID Studente: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (exists("Studenti", id)) break;
                else System.out.println("Non esiste!");
            } else {
                System.out.println("Inserisci un numero!");
                scanner.nextLine();
            }
        }

        System.out.print("Nuovo nome: ");
        String name = scanner.nextLine();
        System.out.print("Nuovo cognome: ");
        String surname = scanner.nextLine();

        String query = "UPDATE Studenti SET nome=?, cognome=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Studente aggiornato!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione modifica voto (per id)
    public static void modifyVote(Scanner scanner) {
        int id;

        // Loop con controllo per id
        while (true) {
            System.out.print("ID Voto: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (exists("Voti", id)) break;
                else System.out.println("Voto non presente!");
            } else {
                System.out.println("Inserisci un numero!");
                scanner.nextLine();
            }
        }

        double vote;

        // Loop con controllo per il voto
        while (true) {
            System.out.print("Nuovo voto: ");
            if (scanner.hasNextDouble()) {
                vote = scanner.nextDouble();
                if (vote >= 0 && vote <= 10) break;
                else System.out.println("Il voto deve essere compreso fra 0-10! \nDecimali inclusi.");
            } else {
                System.out.println("Inserisci un numero!");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        String query = "UPDATE Voti SET voto=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setDouble(1, vote);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Voto aggiornato!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione modifica classe (per id)
    public static void modifyClass(Scanner scanner) {
        int id;

        // Loop con controllo per id
        while (true) {
            System.out.print("ID Classe: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (exists("Classi", id)) break;
                else System.out.println("Classe non esistente!");
            } else {
                System.out.println("Inserisci un numero!");
                scanner.nextLine();
            }
        }

        int grade;

        // Loop con controllo per il grado
        while (true) {
            System.out.print("Nuovo grado: ");
            if (scanner.hasNextInt()) {
                grade = scanner.nextInt();
                scanner.nextLine();
                if (grade >= 1 && grade <= 5) break;
                else System.out.println("Inserisci un numero compreso fra 1-5!");
            } else {
                System.out.println("Inserisci un numero intero!");
                scanner.nextLine();
            }
        }

        System.out.print("Nuova sezione: ");
        String section = scanner.nextLine();

        String query = "UPDATE Classi SET grado=?, sezione=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, grade);
            ps.setString(2, section);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Classe aggiornata!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione modifica materia (per id)
    public static void modifySubject(Scanner scanner) {
        int id;

        // Loop con controllo per id
        while (true) {
            System.out.print("ID Materia: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (exists("Materie", id)) break;
                else System.out.println("Materia non esistente!");
            } else {
                System.out.println("Inserisci un numero intero!");
                scanner.nextLine();
            }
        }

        System.out.print("Nuovo nome: ");
        String name = scanner.nextLine();

        String query = "UPDATE Materie SET nome=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Materia aggiornata!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==================== DELETE ====================
    // Funzione elimina studente (per id)
    public static void removeStudent(Scanner scanner) {
        int id;

        // Loop con controllo per id
        while (true) {
            System.out.print("ID Studente: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (exists("Studenti", id)) break;
                else System.out.println("Studente non presente!");
            } else {
                System.out.println("Inserisci un numero intero!");
                scanner.nextLine();
            }
        }

        String query = "DELETE FROM Studenti WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Studente eliminato!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione elimina voto (per id)
    public static void removeVote(Scanner scanner) {
        int id;

        // Loop con controllo per id
        while (true) {
            System.out.print("ID Voto: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (exists("Voti", id)) break;
                else System.out.println("Voto non presente!");
            } else {
                System.out.println("Inserisci un numero intero!");
                scanner.nextLine();
            }
        }

        String query = "DELETE FROM Voti WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Voto eliminato!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione elimina classe (per id)
    public static void removeClass(Scanner scanner) {
        int id;

        // Loop con controllo per id
        while (true) {
            System.out.print("ID Classe: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (exists("Classi", id)) break;
                else System.out.println("Casse non esistente!");
            } else {
                System.out.println("Inserisci un numero intero!");
                scanner.nextLine();
            }
        }

        String query = "DELETE FROM Classi WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Classe eliminata!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Funzione elimina materia (per id)
    public static void removeSubject(Scanner scanner) {
        int id;

        // Loop con controllo per id
        while (true) {
            System.out.print("ID Materia: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (exists("Materie", id)) break;
                else System.out.println("Materia non presente!");
            } else {
                System.out.println("Inserisci un numero intero!");
                scanner.nextLine();
            }
        }

        String query = "DELETE FROM Materie WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, psw);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Materia eliminata!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}