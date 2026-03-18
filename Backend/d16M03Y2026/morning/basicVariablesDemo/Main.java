package d16M03Y2026.morning.basicVariablesDemo;

// Definizione della classe principale del programma
public class Main {

    // Metodo principale
    public static void main(String[] args) {

        // Dichiarazione ed inizializzazione di una variabile intera
        int number = 1;

        // Dichiarazione ed inizializzazione di una variabile booleana (true o false)
        boolean isItTrue = true;

        // Dichiarazione di una variabile di tipo String (non ancora inizializzata)
        String word;

        // Assegnazione del valore "Hi" alla variabile word
        word = "Hi";

        // Stampa il valore della variabile number
        System.out.println(number);

        // Stampa il valore della variabile booleana
        System.out.println(isItTrue);

        // Stampa la stringa contenuta nella variabile word
        System.out.println(word);

        // Dichiarazione di una costante di tipo char
        // La parola chiave final significa che il valore NON può cambiare
        final char CHAR = 'A';

        // ERRORE: non è possibile modificare una variabile final
        // Questa riga causerebbe un errore di compilazione
        CHAR = 'B';

        // Dichiarazione e inizializzazione di una stringa
        String firstPartOfThePhrase = "Hello";

        // Stampa una frase concatenando:
        // - la variabile firstPartOfThePhrase
        // - la stringa "World!"
        // - il numero convertito in stringa
        System.out.println(firstPartOfThePhrase + "World!" + Integer.toString(number));

        // Dichiarazione di tre variabili intere
        int number1, number2, number3;

        // Integer.parseInt converte una stringa in numero intero
        // Il valore "1425" viene convertito in 1425
        // L'assegnazione multipla assegna lo stesso valore a tutte e tre le variabili
        number1 = number2 = number3 = Integer.parseInt("1425");
    }
}