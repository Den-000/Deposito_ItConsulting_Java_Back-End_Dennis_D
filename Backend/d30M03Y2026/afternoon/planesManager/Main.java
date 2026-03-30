package d30M03Y2026.afternoon.planesManager;
import java.util.ArrayList;

// Classe Aereo
class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    // Costruttore
    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        setNumeroPosti(numeroPosti); // controllo n positivo
        this.codice = codice;
    }

    // Getter e Setter
    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Errore: numero posti deve essere positivo.");
        }
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    // Metodo per stampare info aereo / tostring
    public void stampaInfo() {
        System.out.println("Aereo: " + modello + ", Posti: " + numeroPosti + ", Codice: " + codice);
    }
}

// Classe Pilota
class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    // Costruttore
    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        setOreVolo(oreVolo); // controllo n positivo
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    public int getOreVolo() {
        return oreVolo;
    }

    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Errore: le ore di volo devono essere maggiori di zero.");
        }
    }

    // tostring
    public void stampaInfo() {
        System.out.println("Pilota: " + nome + ", Brevetto: " + numeroBrevetto + ", Ore di volo: " + oreVolo);
    }
}

// Classe CompagniaAerea
class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;

    // Costruttore
    public CompagniaAerea(String nome) {
        this.nome = nome;
        flotta = new ArrayList<>();
        piloti = new ArrayList<>();
    }

    // Metodi per aggiungere aerei e piloti
    public void addAereo(Aereo aereo) {
        flotta.add(aereo);
    }

    public void addPilota(Pilota pilota) {
        piloti.add(pilota);
    }

    // Metodo per stampare tutte le info
    public void stampaInfoCompagnia() {
        System.out.println("Compagnia Aerea: " + nome);
        System.out.println("Flotta:");
        for (Aereo aereo : flotta) {
            aereo.stampaInfo();
        }
        System.out.println("Piloti:");
        for (Pilota pilota : piloti) {
            pilota.stampaInfo();
        }
    }
}

// Classe principale con main
public class Main {
    public static void main(String[] args) {
        // Creiamo la compagnia aerea
        CompagniaAerea compagnia = new CompagniaAerea("SkyFly");

        // Creiamo due aerei
        Aereo aereo1 = new Aereo("Boeing 737", 180, "B737-001");
        Aereo aereo2 = new Aereo("Airbus A320", 150, "A320-002");

        // Creiamo due piloti
        Pilota pilota1 = new Pilota("Mario Rossi", "BR1234", 1200);
        Pilota pilota2 = new Pilota("Luca Bianchi", "BR5678", 800);

        // Aggiungiamo aerei e piloti alla compagnia
        compagnia.addAereo(aereo1);
        compagnia.addAereo(aereo2);
        compagnia.addPilota(pilota1);
        compagnia.addPilota(pilota2);

        // Stampiamo tutte le informazioni
        compagnia.stampaInfoCompagnia();
    }
}