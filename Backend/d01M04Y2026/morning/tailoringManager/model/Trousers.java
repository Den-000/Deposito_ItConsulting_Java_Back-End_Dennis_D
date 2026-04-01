package tailoringManager.model;

public class Trousers extends MainGarment {
    private String fitType;

    public Trousers(String code, String name, String fabric, String color, String size, double price, String fitType) {
        super(code, name, fabric, color, size, price);
        this.fitType = fitType;
    }

    @Override
    public String showDetails() {
        return "PANTALONE: " + getName() + ", Taglio: " + fitType + ", Prezzo: " + getPrice();
    }
}