package view;

import java.util.Scanner;

public class ConsoleView {
    @SuppressWarnings("unused")
    private Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void showLogin() {
        System.out.println("\n===== LOGIN =====");
        System.out.println("1) Login");
        System.out.println("2) Registrati");
        System.out.println("0) Esci");
        System.out.println("=================");
    }

    public void showMainMenu() {
        System.out.println("\n===== MENU PRINCIPALE =====");
        System.out.println("1) Visualizza account");
        System.out.println("2) Modifica username");
        System.out.println("3) Modifica password");
        System.out.println("4) Elimina account");
        System.out.println("0) Logout");
        System.out.println("===========================");
    }
}