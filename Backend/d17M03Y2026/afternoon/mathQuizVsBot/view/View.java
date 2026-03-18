package d17M03Y2026.afternoon.mathQuizVsBot.view;

import java.util.concurrent.TimeUnit;

public class View {
    // *DA IMPLEMENTARE "2) Opzioni" → possibilità di impostare difficoltà delle domande e del bot*

    // Mostra il menu principale
    public static void showMenu(){
        System.out.println("=========== MENU =========");
        System.out.println("Benvenuto nella gara di matematica!");
        System.out.println("1) Gioca");
        System.out.println("2) Esci");
        System.out.println("==========================\n");
    }

    // Animazione di caricamento con tre puntini
    public static void loading(){
        for(int i=0; i<3; i++){
            System.out.print(".");
            try {
                TimeUnit.MILLISECONDS.sleep(500); // Pausa di 0.5 secondi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Introduzione del game master
    public static void gameMasterIntro(){
        System.out.println("Benvenuto nella gara di matematica. \nTi verranno proposti 10 semplici quesiti matematici, ma chi sarà ad avere la meglio?\nSarai tu contro il nostro miglior bot!\nChe vinca il migliore!\n\n");
        System.out.println("Iniziamo.");
        separationBarAndLineBreak();
    }

    // Stampa il numero del round
    public static void printRoundNumber(int roundNumber){
        System.out.println("===== Round numero " + Integer.toString(roundNumber) + " =====");
    }

    // Stampa una stringa senza andare a capo
    public static void print(String textToPrint){
        System.out.print(textToPrint);
    }

    // Stampa una barra di separazione senza andare a capo
    public static void separationBar(){
        System.out.print("=========================="); // 26 "="
    }

    // Stampa barra di separazione con ritorno a capo
    public static void separationBarAndLineBreak(){
        System.out.println("==========================\n");
    }
}