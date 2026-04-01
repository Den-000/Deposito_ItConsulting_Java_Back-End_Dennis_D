package tailoringManager.model;

// ===== SOTTOCLASSE GIACCA =====
public class Jacket extends MainGarment {
    private int buttonCount;

    public Jacket(String code, String name, String fabric, String color, String size, double price, int buttonCount) {
        super(code, name, fabric, color, size, price);
        this.buttonCount = buttonCount;
    }

    @Override
    public String showDetails() {
        return "GIACCA: " + getName() + ", Bottoni: " + buttonCount + ", Prezzo: " + getPrice();
    }
}