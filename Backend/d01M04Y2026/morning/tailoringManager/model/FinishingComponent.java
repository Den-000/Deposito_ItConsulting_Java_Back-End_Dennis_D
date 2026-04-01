package tailoringManager.model;

// ===== CLASSE BASE COMPONENTE FINITURA =====
public abstract class FinishingComponent {
    private String code;
    private String name;
    private String material;
    private String color;
    private double price;

    public FinishingComponent(String code, String name, String material, String color, double price) {
        setCode(code);
        setName(name);
        setMaterial(material);
        setColor(color);
        setPrice(price);
    }

    public String getCode() { return code; }
    public void setCode(String code) {
        if (code != null && !code.isEmpty())
            this.code = code;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) {
        if (material != null && !material.isEmpty())
            this.material = material;
    }

    public String getColor() { return color; }
    public void setColor(String color) {
        if (color != null && !color.isEmpty())
            this.color = color;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    // METODO POLIMORFICO
    public abstract String showDetails();
}