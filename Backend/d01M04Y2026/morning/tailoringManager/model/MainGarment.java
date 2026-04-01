package tailoringManager.model;

// ===== CLASSE BASE CAPO PRINCIPALE =====
public abstract class MainGarment {
    private String code;
    private String name;
    private String fabric;
    private String color;
    private String size;
    private double price;

    public MainGarment(String code, String name, String fabric, String color, String size, double price) {
        setCode(code);
        setName(name);
        setFabric(fabric);
        setColor(color);
        setSize(size);
        setPrice(price);
    }

    // GETTER E SETTER CON CONTROLLI
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

    public String getFabric() { return fabric; }
    public void setFabric(String fabric) {
        if (fabric != null && !fabric.isEmpty())
            this.fabric = fabric;
    }

    public String getColor() { return color; }
    public void setColor(String color) {
        if (color != null && !color.isEmpty())
            this.color = color;
    }

    public String getSize() { return size; }
    public void setSize(String size) {
        if (size != null && !size.isEmpty())
            this.size = size;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    // METODO POLIMORFICO (ritorna stringa)
    public abstract String showDetails();
}