import controller.Calcolatore;
import model.Addizione;
import model.Moltiplicazione;

public class App {
    public static void main(String[] args) throws Exception {
        Calcolatore calcolatore = new Calcolatore();

        // Strategia Addizione
        calcolatore.setOperazione(new Addizione());
        System.out.println("Addizione: " + calcolatore.calcola(5, 3));

        // Cambio strategia a runtime
        calcolatore.setOperazione(new Moltiplicazione());
        System.out.println("Moltiplicazione: " + calcolatore.calcola(5, 3));
    }
}
