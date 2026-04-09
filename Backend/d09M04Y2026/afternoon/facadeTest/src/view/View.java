package view;

public class View {

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }
    
    public void displayMenu() {
        System.out.println("==== Main Menu ====");
        System.out.println("1) Accendi tutte le luci");
        System.out.println("2) Accendi luce cucina");
        System.out.println("3) Accendi luce soggiorno");
        System.out.println("0) Esci");
        System.out.println("===================");
    }
}
