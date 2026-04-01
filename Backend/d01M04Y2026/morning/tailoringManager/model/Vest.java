package tailoringManager.model;

public class Vest extends MainGarment {
    private boolean hasFold;

    public Vest(String code, String name, String fabric, String color, String size, double price, boolean hasFold) {
        super(code, name, fabric, color, size, price);
        this.hasFold = hasFold;
    }

    @Override
    public String showDetails() {
        return "GILET: " + getName() + ", Piega: " + hasFold + ", Prezzo: " + getPrice();
    }
}