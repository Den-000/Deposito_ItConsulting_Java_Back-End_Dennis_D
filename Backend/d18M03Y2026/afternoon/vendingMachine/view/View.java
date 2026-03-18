package d18M3Y2026.afternoon.vendingMachine.view;

import java.util.concurrent.TimeUnit;

public class View {

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