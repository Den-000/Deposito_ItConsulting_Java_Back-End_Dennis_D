package d20M03Y2026.afternoon.bookObjTest;

// Classe che rappresenta un libro
public class Book {
    
    // Variabile statica condivisa tra tutti gli oggetti Book
    // Serve per generare un ID unico per ogni libro creato
    private static int counter = 0;

    // Variabili d'istanza (specifiche per ogni libro)
    private int id;         // ID univoco del libro
    private String title;   // Titolo del libro
    private String author;  // Autore del libro
    private double price;   // Prezzo del libro

    // ======================
    // COSTRUTTORI
    // ======================

    // Costruttore vuoto: genera solo un ID univoco
    public Book() {
        this.id = ++counter;  // Incrementa il contatore e assegna l'ID
    }

    // Costruttore con titolo: genera ID e imposta il titolo
    public Book(String title) {
        this.id = ++counter;
        this.title = title;
    }

    // Costruttore con titolo e autore: genera ID, titolo e autore
    public Book(String title, String author) {
        this.id = ++counter;
        this.title = title;
        this.author = author;
    }

    // Costruttore completo: genera ID e imposta titolo, autore e prezzo
    public Book(String title, String author, double price) {
        this.id = ++counter;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // ======================
    // GETTER & SETTER
    // ======================

    // Restituisce l'ID del libro
    public int getId() {
        return id;
    }

    // Imposta l'ID del libro (privato, opzionale)
    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }

    // Restituisce il titolo del libro
    public String getTitle() {
        return title;
    }

    // Imposta il titolo del libro
    public void setTitle(String title) {
        this.title = title;
    }

    // Restituisce l'autore del libro
    public String getAuthor() {
        return author;
    }

    // Imposta l'autore del libro
    public void setAuthor(String author) {
        this.author = author;
    }

    // Restituisce il prezzo del libro
    public double getPrice() {
        return price;
    }

    // Imposta il prezzo del libro
    public void setPrice(double price) {
        this.price = price;
    }
}