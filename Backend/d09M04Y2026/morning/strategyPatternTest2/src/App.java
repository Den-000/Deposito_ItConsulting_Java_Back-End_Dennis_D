import java.util.Scanner;

import controller.PagamentoController;
import model.CartaDiCredito;
import model.PayPal;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PagamentoController controller = new PagamentoController();

        System.out.println("Scegli metodo di pagamento:");
        System.out.println("1) Carta di Credito");
        System.out.println("2) PayPal");

        int scelta = scanner.nextInt();
        scanner.nextLine();

        if (scelta == 1) {
            System.out.print("Inserisci nome intestatario: ");
            String nome = scanner.nextLine();

            System.out.print("Inserisci numero carta: ");
            String numero = scanner.nextLine();

            controller.setMetodo(new CartaDiCredito(nome, numero));

        } else if (scelta == 2) {
            System.out.print("Inserisci email PayPal: ");
            String email = scanner.nextLine();

            controller.setMetodo(new PayPal(email));

        } else {
            System.out.println("Scelta non valida!");
            scanner.close();
            return;
        }

        System.out.print("Inserisci importo da pagare: ");
        double importo = scanner.nextDouble();

        // Esecuzione pagamento
        controller.eseguiPagamento(importo);

        scanner.close();
    }
}
