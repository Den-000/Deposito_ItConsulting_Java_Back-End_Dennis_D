package d16M03Y2026.morning.stringSyntaxErrors;

// Definizione della classe principale del programma
public class Main {

    // Metodo main
    public static void main(String[] args) {

        // Stampa la stringa "Hello" sulla console e va a capo
        // Le doppie virgolette "" in Java servono per definire una STRINGA
        System.out.println("Hello");

        // ERRORE: 'Hi' usa gli apici singoli
        // In Java gli apici singoli servono solo per un singolo carattere (char)
        // Esempio valido: 'H'
        // 'Hi' contiene due caratteri quindi genera un errore di compilazione
        System.out.println('Hi');

        // ERRORE: i backtick ` ` non esistono in Java per definire stringhe
        // Sono usati in altri linguaggi (es. JavaScript o Markdown)
        // In Java bisogna usare sempre le doppie virgolette ""
        System.out.println(`Hi`);
    }
}