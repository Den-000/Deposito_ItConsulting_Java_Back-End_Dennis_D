import java.util.*; // Importa tutte le classi del package java.util (serve per usare Scanner)

public class Main { // Definizione della classe principale del programma
    public static void main(String[] args) { // Metodo main: punto di partenza del programma

        Scanner input = new Scanner(System.in); // Crea un oggetto Scanner per leggere input da tastiera

        System.out.println("Come stai?"); // Stampa una domanda sulla console

        String iFeel = input.nextLine(); // Legge una riga di testo inserita dall'utente e la salva nella variabile iFeel

        System.out.println("Mi sento " + iFeel); // Stampa il messaggio concatenando la risposta dell'utente

        input.close(); // Chiude lo Scanner per liberare le risorse
    }
}