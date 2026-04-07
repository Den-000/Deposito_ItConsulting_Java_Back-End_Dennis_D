package view;

import java.time.LocalDateTime;              // Per ottenere data ed ora correnti
import java.time.format.DateTimeFormatter;  // Per formattare la data

public class ConsoleView {

    // Metodo per stampare un messaggio con data e ora
    public void showMsg(String msg) {

        // Definisce il formato della data (giorno-mese-anno ora:minuti)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // Ottiene la data e ora corrente e la formatta
        String dateNow = LocalDateTime.now().format(formatter);

        // Stampa il messaggio con timestamp
        System.out.println("[" + dateNow + "] " + msg);
    }
}