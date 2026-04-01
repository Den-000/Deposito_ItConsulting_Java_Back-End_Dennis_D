package tailoringManager.model;

public class Tie extends FinishingComponent {
    private double width;

    public Tie(String code, String name, String material, String color, double price, double width) {
        super(code, name, material, color, price);
        this.width = width;
    }

    @Override
    public String showDetails() {
        return "CRAVATTA: " + getName() + ", Larghezza: " + width + ", Prezzo: " + getPrice();
    }
}