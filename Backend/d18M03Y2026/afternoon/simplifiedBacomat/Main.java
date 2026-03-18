package d18M3Y2026.afternoon.simplifiedBacomat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean loop = true;
        int choice;
        int amountAvaible = 0;

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1) Visualizza saldo");
            System.out.println("2) Preleva");
            System.out.println("3) Deposita");
            System.out.println("4) Esci");
            System.out.println("==========================");
            choice = askInt();
            switch (choice) {
                case 1:
                    System.out.println("\nIl saldo attuale ammonta a: " + amountAvaible + "€\n");
                    break;
                    
                case 2:
                    System.out.println("\nQuanto vuoi prelevare?");
                    System.out.println("(n.b. Solo numeri interi)");
                    amountAvaible = withdraw(askInt(), amountAvaible);
                    break;

                case 3:
                    System.out.println("\nQuanto vuoi depositare?");
                    System.out.println("(n.b. Solo numeri interi)");
                    amountAvaible = deposit(askInt(), amountAvaible);
                    break;

                case 4:
                    loop = false;
                    System.out.println("Arrivederci!");
                    break;
            
                default:
                    break;
            }
        } while (loop);
    }


    public static int withdraw(int amountToWithdraw, int amountAvaible){
        if (amountAvaible >= amountToWithdraw) {
            amountAvaible -= amountToWithdraw;

            System.out.println("\nIl nuovo saldo ammonta a: " + amountAvaible + "€\n");
        } else {
            System.out.println("Cifra non valida!\n");
        }
        return amountAvaible;
        // EQUIVALENTE DI:
        // int amountToWithdraw = Integer.parseInt(scanner.nextLine());
        // if (amountAvaible >= amountToWithdraw) {
        //     amountAvaible -= amountToWithdraw;

        //     System.out.println("\nIl nuovo saldo ammonta a: " + amountAvaible + "€\n");
        // } else {
        //     System.out.println("Cifra non valida!\n");
        // }

    }

    public static int deposit(int amountToDeposit, int amountAvaible){
        if (amountToDeposit > 0) {
            amountAvaible += amountToDeposit;

            System.out.println("\nIl nuovo saldo ammonta a: " + amountAvaible + "€\n");
        } else {
            System.out.println("Cifra non valida!\n");
        }
        return amountAvaible;
    }


     // Chiede un input integer e verifica validità
     @SuppressWarnings("resource")
    public static int askInt() {
         Scanner scanner = new Scanner(System.in);
         while (true) {
             try {
                 String input = scanner.nextLine();
                 int value = Integer.parseInt(input); // Converte stringa in int
                 return value;
             } catch (NumberFormatException e) {
                 System.out.println("Errore: inserisci un numero intero valido.\n");
             }
         }
     }
 
     // Chiede un input double e verifica validità
     @SuppressWarnings("resource")
    public static double askDouble() {
         Scanner scanner = new Scanner(System.in);
         while (true) {
             try {
                 String input = scanner.nextLine();
                 double value = Double.parseDouble(input); // Converte stringa in double
                 return value;
             } catch (NumberFormatException e) {
                 System.out.println("Errore: inserisci un numero decimale valido.\n");
             }
         }
     }
 
     // Chiede un input stringa (nessun controllo sul tipo)
     @SuppressWarnings("resource")
    public static String askString() {
         Scanner scanner = new Scanner(System.in);
         return scanner.nextLine();
     }
}