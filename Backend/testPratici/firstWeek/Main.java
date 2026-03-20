package testPratici.firstWeek; // Dhichiarazione del package

// Import
import java.util.ArrayList;
import java.util.Scanner;

public class Main { // Classe principale (monolite)
    public static void main(String[] args) { // Punto d'ingresso del programma

        // Liste per memorizzare i nomi dei prodotti e le quantità corrispondenti
        ArrayList<String> productsName = new ArrayList<>();
        ArrayList<Integer> productsQuantity = new ArrayList<>();
        
        Scanner input = new Scanner(System.in); // Scanner per leggere input da tastiera

        int choice; // Variabile per navigare nel menu

        // CICLO PRINCIPALE: mostra menu e gestisce le scelte
        while (true) {
            showMenu(); // Mostra il menu
            try {
                choice = Integer.parseInt(input.nextLine()); // Legge input come stringa e converte
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero valido!");
                continue; // Torna all'inizio del ciclo senza chiudere il programma
            }

            switch (choice) {

                case 1: // Aggiungi prodotto
                    addProduct(input, productsName, productsQuantity);
                    break;

                case 2: // Visualizza tutti i prodotti
                    viewAllProducts(productsName, productsQuantity);
                    break;

                case 3: // Cerca prodotto per nome
                    findProductByName(input, productsName, productsQuantity);
                    break;

                case 4: // Modifica quantità di un prodotto
                    modifyQuantity(input, productsName, productsQuantity);
                    break;

                case 5: // Rimuovi prodotto
                    removeProduct(input, productsName, productsQuantity);
                    break;

                case 6: // Calcola totale pezzi prodotti
                    calculateTotalQuantityOfProducts(productsQuantity);
                    break;

                case 7: // Esci dal programma
                    System.out.println("Uscita dal programma...");
                    return; // Termina il main e chiude il programma

                default: // Scelta non valida
                    System.out.println("Scelta non valida.\nRiprova!");
                    break;
            }
        }
    }

    // ===== FUNZIONI DI SUPPORTO =====

    // Mostra il menu principale
    public static void showMenu() {
        System.out.println("\n\n=== Menu Gestione Produzione ===");
        System.out.println("1) Aggiungi prodotto");
        System.out.println("2) Visualizza produzione");
        System.out.println("3) Cerca prodotto");
        System.out.println("4) Modifica quantità");
        System.out.println("5) Rimuovi prodotto");
        System.out.println("6) Calcola totale pezzi prodotti");
        System.out.println("7) Esci");
        System.out.println("================================");
        System.out.print("Scegli un'opzione: ");
    }

    // Aggiunge un nuovo prodotto con quantità
    public static void addProduct(Scanner input, ArrayList<String> productsName, ArrayList<Integer> productsQuantity) {
        // Controllo nome non vuoto
        String name;
        boolean validInput = false;
        do {
            System.out.print("\n\nInserisci il nome del prodotto: ");
            name = input.nextLine();
            if (!name.isEmpty()) {
                validInput = true;
            } else {
                System.out.println("Errore: il nome del prodotto non può essere vuoto!");
            }
        } while (!validInput); // Se "false" ripeti

        // Controllo quantità maggiore di 0
        int quantity = 0;
        validInput = false;
        do {
            System.out.print("\n\nInserisci la quantità prodotta: ");
            try {
                quantity = Integer.parseInt(input.nextLine());
                if (quantity > 0) {
                    validInput = true;
                } else {
                    System.out.println("Errore: la quantità deve essere maggiore di 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero intero valido!");
            }
        } while (!validInput); // Se "false" ripeti

        productsName.add(name); // Aggiunge nome alla corrispettiva ArrayList
        productsQuantity.add(quantity); // Aggiunge quantità alla corrispettiva ArrayList
        System.out.println("\n\nProdotto aggiunto correttamente!");
    }

    // Visualizza tutti i prodotti registrati
    public static void viewAllProducts(ArrayList<String> productsName, ArrayList<Integer> productsQuantity) {
        if (productsName.isEmpty()) { // Controlla che la lista non sia vuota
            System.out.println("Nessun prodotto registrato"); // Se è vuota stampa e ritorna/termina
            return;
        }

        System.out.println("\n\n=== Produzione Registrata ===");
        // Ciclo for per stampare nome e quantità dei prodotti
        for (int i = 0; i < productsName.size(); i++) {
            System.out.println((i + 1) + " - " + productsName.get(i) + " | Quantità: " + productsQuantity.get(i));
        }
    }

    // Cerca un prodotto per nome
    public static void findProductByName(Scanner input, ArrayList<String> productsName, ArrayList<Integer> productsQuantity) {
        System.out.print("\n\nInserisci il nome del prodotto da cercare: ");
        String name = input.nextLine();

        int index = productsName.indexOf(name); // Cerca l'indice del prodotto

        if (index != -1) { // ArrayList ritorna -1 se l'elemento cercato non è presente, quindi, se ritorna qualcosa di diverso da -1, stampalo
            System.out.println("\n\nProdotto trovato: " + productsName.get(index) + " | Quantità: " + productsQuantity.get(index));
        } else {
            System.out.println("Prodotto non trovato");
        }
    }

    // Modifica la quantità di un prodotto esistente
    public static void modifyQuantity(Scanner input, ArrayList<String> productsName, ArrayList<Integer> productsQuantity) {
        System.out.print("\n\nInserisci il nome del prodotto da modificare: ");
        String name = input.nextLine();

        int index = productsName.indexOf(name); // Cerca l'indice del prodotto

        if (index != -1) {
            // Controllo sulla quantità, > 0
            int newQuantity = 0;
            boolean validInput = false;
            do {
                System.out.print("\n\nInserisci la nuova quantità: ");
                try {
                    newQuantity = Integer.parseInt(input.nextLine());
                    if (newQuantity > 0) {
                        validInput = true;
                    } else {
                        System.out.println("Errore: la quantità deve essere maggiore di 0!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Errore: inserisci un numero intero valido!");
                }
            } while (!validInput); // Se "false" ripeti

            productsQuantity.set(index, newQuantity); // Aggiorna quantità
            System.out.println("\n\nQuantità aggiornata correttamente!");
        } else {
            System.out.println("Prodotto non trovato");
        }
    }

    // Rimuove un prodotto dalla lista
    public static void removeProduct(Scanner input, ArrayList<String> productsName, ArrayList<Integer> productsQuantity) {
        System.out.print("\nInserisci il nome del prodotto da rimuovere: ");
        String name = input.nextLine();

        int index = productsName.indexOf(name);

        if (index != -1) {// Se l'elemento è presente rimuovi sia il nome che la quantità associati a quell'indice
            productsName.remove(index);
            productsQuantity.remove(index);
            System.out.println("\n\nProdotto rimosso correttamente!");
        } else {
            System.out.println("Prodotto non trovato");
        }
    }

    // Calcola il totale dei pezzi prodotti
    public static void calculateTotalQuantityOfProducts(ArrayList<Integer> productsQuantity) {
        int totalNumOfProducts = 0;

        // Ciclo for-each per sommare tutte le quantità
        for (int productQuantity : productsQuantity) {
            totalNumOfProducts += productQuantity;
        }

        System.out.println("\n\nTotale pezzi prodotti: " + totalNumOfProducts);
    }
}