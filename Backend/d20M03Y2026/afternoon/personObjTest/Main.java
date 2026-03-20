package d20M03Y2026.afternoon.personObjTest;

import java.util.ArrayList;
import java.util.Scanner;

// Classe principale per la gestione delle persone
public class Main {

    // Lista globale che contiene tutte le persone
    static ArrayList<Person> people = new ArrayList<>();
    // Scanner per leggere input da tastiera
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        // Ciclo principale del programma: mostra il menu finché l'utente non esce
        do {
            showMenu();                 // Mostra il menu
            System.out.print("Scelta: ");
            choice = askInt();          // Chiede la scelta dell'utente

            // Gestione delle varie opzioni
            switch (choice) {
                case 1:
                    addPerson();       // Aggiunge una nuova persona
                    break;
                case 2:
                    searchPerson();    // Cerca una persona tramite ID
                    break;
                case 3:
                    showAllPeople();   // Mostra tutte le persone
                    break;
                case 4:
                    editPerson();      // Modifica i dati di una persona
                    break;
                case 5:
                    removePerson();    // Rimuove una persona
                    break;
                case 6:
                    System.out.println("Uscita..."); // Termina il programma
                    break;
                default:
                    System.out.println("Scelta non valida."); // Gestione errore
            }

        } while (choice != 6); // Continua finché l’utente non sceglie 6
    }

    // Mostra il menu principale
    static void showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1) Aggiungi persona");
        System.out.println("2) Cerca persona");
        System.out.println("3) Visualizza tutte le persone");
        System.out.println("4) Modifica persona");
        System.out.println("5) Rimuovi persona");
        System.out.println("6) Esci");
        System.out.println("================");
    }

    // Aggiunge una nuova persona alla lista
    static void addPerson() {
        System.out.print("Nome: ");
        String name = askString();

        System.out.print("Età: ");
        int years = askInt();

        System.out.print("Città: ");
        String city = askString();

        Person p = new Person(name, years, city);
        people.add(p);

        System.out.println("Persona aggiunta con ID: " + p.getId());
    }

    // Cerca una persona tramite ID
    static void searchPerson() {
        System.out.print("Inserisci ID: ");
        int id = askInt();

        for (Person p : people) {
            if (p.getId() == id) {
                printPerson(p);
                return;
            }
        }

        System.out.println("Persona non trovata.");
    }

    // Mostra tutte le persone presenti
    static void showAllPeople() {
        if (people.isEmpty()) {
            System.out.println("Nessuna persona presente.");
            return;
        }

        for (Person p : people) {
            printPerson(p);
        }
    }

    // Modifica i dati di una persona tramite ID
    static void editPerson() {
        System.out.print("ID persona da modificare: ");
        int id = askInt();

        for (Person p : people) {
            if (p.getId() == id) {
                System.out.print("Nuovo nome: ");
                p.setName(askString());

                System.out.print("Nuova età: ");
                p.setYears(askInt());

                System.out.print("Nuova città: ");
                p.setCity(askString());

                System.out.println("Persona aggiornata.");
                return;
            }
        }

        System.out.println("Persona non trovata.");
    }

    // Rimuove una persona tramite ID
    static void removePerson() {
        System.out.print("ID persona da rimuovere: ");
        int id = askInt();

        for (Person p : people) {
            if (p.getId() == id) {
                people.remove(p);
                System.out.println("Persona rimossa.");
                return;
            }
        }

        System.out.println("Persona non trovata.");
    }

    // Stampa i dettagli di una persona
    static void printPerson(Person p) {
        System.out.println("\nID: " + p.getId());
        System.out.println("Nome: " + p.getName());
        System.out.println("Età: " + p.getYears());
        System.out.println("Città: " + p.getCity());
        System.out.println("================");
    }

    // ======================
    // METODI PER INPUT SICURO
    // ======================

    // Legge un intero in modo sicuro
    public static int askInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Numero non valido, riprova: ");
            }
        }
    }

    // Legge una stringa
    public static String askString() {
        return scanner.nextLine();
    }
}

// ======================
// CLASSE PERSON
// ======================

// Classe che rappresenta una persona
class Person {

    private static int counter = 1; // Contatore per generare ID univoci

    private int id;      // ID univoco della persona
    private String name; // Nome
    private int years;   // Età
    private String city; // Città

    // Costruttore: inizializza una persona e assegna un ID univoco
    public Person(String name, int years, String city) {
        this.id = counter++; // Incrementa il contatore per ID univoci
        this.name = name;
        this.years = years;
        this.city = city;
    }

    // ======================
    // GETTER
    // ======================
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYears() {
        return years;
    }

    public String getCity() {
        return city;
    }

    // ======================
    // SETTER
    // ======================
    public void setName(String name) {
        this.name = name;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setCity(String city) {
        this.city = city;
    }
}