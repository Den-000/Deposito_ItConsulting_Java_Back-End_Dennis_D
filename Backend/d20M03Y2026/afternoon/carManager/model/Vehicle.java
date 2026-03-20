package d20M03Y2026.afternoon.carManager.model;

// Classe che rappresenta un veicolo
public class Vehicle {

    // ======================
    // VARIABILI D'ISTANZA
    // ======================
    private String brand;   // Marca del veicolo (es. Fiat, Toyota)
    private String model;   // Modello del veicolo (es. Panda, Corolla)
    private int year;       // Anno di immatricolazione del veicolo
    private double price;   // Prezzo del veicolo

    // ======================
    // COSTRUTTORE
    // ======================
    // Inizializza un nuovo oggetto Vehicle con tutti i dettagli
    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;   // Assegna la marca
        this.model = model;   // Assegna il modello
        this.year = year;     // Assegna l'anno
        this.price = price;   // Assegna il prezzo
    }

    // ======================
    // GETTER
    // ======================
    // Restituiscono i valori delle variabili d'istanza

    // Restituisce la marca del veicolo
    public String getBrand() {
        return brand;
    }

    // Restituisce il modello del veicolo
    public String getModel() {
        return model;
    }

    // Restituisce l'anno di immatricolazione
    public int getYear() {
        return year;
    }

    // Restituisce il prezzo del veicolo
    public double getPrice() {
        return price;
    }

    // ======================
    // SETTER
    // ======================
    // Permettono di modificare i valori delle variabili d'istanza

    // Imposta la marca del veicolo
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Imposta il modello del veicolo
    public void setModel(String model) {
        this.model = model;
    }

    // Imposta l'anno di immatricolazione
    public void setYear(int year) {
        this.year = year;
    }

    // Imposta il prezzo del veicolo
    public void setPrice(double price) {
        this.price = price;
    }
}