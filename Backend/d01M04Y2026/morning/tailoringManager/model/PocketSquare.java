package tailoringManager.model;

public class PocketSquare extends FinishingComponent {
    private String foldStyle;

    public PocketSquare(String code, String name, String material, String color, double price, String foldStyle) {
        super(code, name, material, color, price);
        this.foldStyle = foldStyle;
    }

    @Override
    public String showDetails() {
        return "POCHETTE: " + getName() + ", Piega: " + foldStyle + ", Prezzo: " + getPrice();
    }
}