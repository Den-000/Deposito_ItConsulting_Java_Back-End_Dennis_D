package d20M03Y2026.afternoon.bookObjTest;

import java.util.ArrayList;
import java.util.Scanner;

// Classe principale dell'applicazione per la gestione di una libreria
public class Main {

    // Lista che contiene tutti i libri della libreria
    static ArrayList<Book> library = new ArrayList<>();

    // Scanner per leggere l'input da tastiera
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        // Ciclo principale del programma: mostra il menu finché l'utente non esce
        do {
            showMenu();  // Mostra le opzioni disponibili
            System.out.print("Scelta: ");
            choice = askInt();  // Chiede all'utente di inserire un numero

            // Gestione della scelta dell'utente
            switch (choice) {
                case 1:
                    addBook();      // Aggiungi un nuovo libro
                    break;
                case 2:
                    searchBook();   // Cerca un libro per ID
                    break;
                case 3:
                    showAllBooks(); // Mostra tutti i libri
                    break;
                case 4:
                    editBook();     // Modifica i dati di un libro
                    break;
                case 5:
                    removeBook();   // Rimuovi un libro
                    break;
                case 6:
                    System.out.println("Uscita..."); // Termina il programma
                    break;
                default:
                    System.out.println("Scelta non valida."); // Gestione errori
            }

        } while (choice != 6); // Continua finché l'utente non sceglie di uscire
    }

    // Mostra il menu principale dell'applicazione
    static void showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1) Aggiungi libro");
        System.out.println("2) Cerca libro");
        System.out.println("3) Visualizza tutti i libri");
        System.out.println("4) Modifica libro");
        System.out.println("5) Rimuovi libro");
        System.out.println("6) Esci");
        System.out.println("================");
    }

    // Aggiunge un nuovo libro alla libreria
    static void addBook() {
        System.out.print("Titolo: ");
        String title = askString();  // Chiede il titolo

        System.out.print("Autore: ");
        String author = askString(); // Chiede l'autore

        System.out.print("Prezzo: ");
        double price = askDouble();  // Chiede il prezzo

        // Crea il libro usando il costruttore completo e lo aggiunge alla libreria
        Book book = new Book(title, author, price);
        library.add(book);

        System.out.println("Libro aggiunto con ID: " + book.getId());
    }

    // Cerca un libro nella libreria tramite ID
    static void searchBook() {
        System.out.print("Inserisci ID: ");
        int id = askInt();

        for (Book b : library) {
            if (b.getId() == id) {  // Confronta l'ID
                printBook(b);       // Stampa le informazioni del libro trovato
                return;
            }
        }

        System.out.println("Libro non trovato."); // Messaggio se non esiste
    }

    // Mostra tutti i libri presenti nella libreria
    static void showAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Nessun libro presente.");
            return;
        }

        for (Book b : library) {
            printBook(b); // Stampa ogni libro
        }
    }

    // Modifica i dati di un libro tramite ID
    static void editBook() {
        System.out.print("ID libro da modificare: ");
        int id = askInt();

        for (Book b : library) {
            if (b.getId() == id) {
                // Chiede all'utente di inserire i nuovi dati
                System.out.print("Nuovo titolo: ");
                b.setTitle(askString());

                System.out.print("Nuovo autore: ");
                b.setAuthor(askString());

                System.out.print("Nuovo prezzo: ");
                b.setPrice(askDouble());

                System.out.println("Libro aggiornato.");
                return;
            }
        }

        System.out.println("Libro non trovato.");
    }

    // Rimuove un libro dalla libreria tramite ID
    static void removeBook() {
        System.out.print("ID libro da rimuovere: ");
        int id = askInt();

        // Ciclo per trovare il libro e rimuoverlo
        for (Book b : library) {
            if (b.getId() == id) {
                library.remove(b);
                System.out.println("Libro rimosso.");
                return;
            }
        }

        System.out.println("Libro non trovato.");
    }

    // Stampa i dettagli di un libro
    static void printBook(Book b) {
        System.out.println("\nID: " + b.getId());
        System.out.println("Titolo: " + b.getTitle());
        System.out.println("Autore: " + b.getAuthor());
        System.out.println("Prezzo: " + b.getPrice());
        System.out.println("================");
    }

    // ======================
    // METODI PER LA LETTURA DELL'INPUT
    // ======================

    // Legge un numero intero da tastiera con controllo degli errori
    public static int askInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Numero non valido, riprova: ");
            }
        }
    }

    // Legge un numero decimale da tastiera con controllo degli errori
    public static double askDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Numero non valido, riprova: ");
            }
        }
    }

    // Legge una stringa da tastiera
    public static String askString() {
        return scanner.nextLine();
    }
}