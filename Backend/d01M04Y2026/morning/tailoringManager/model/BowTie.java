package tailoringManager.model;

public class BowTie extends FinishingComponent {
    private String closureType;

    public BowTie(String code, String name, String material, String color, double price, String closureType) {
        super(code, name, material, color, price);
        this.closureType = closureType;
    }

    @Override
    public String showDetails() {
        return "PAPILLON: " + getName() + ", Chiusura: " + closureType + ", Prezzo: " + getPrice();
    }
}