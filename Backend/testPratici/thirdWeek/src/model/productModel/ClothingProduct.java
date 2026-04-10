package model.productModel;

public class ClothingProduct implements Product {

    private int id;
    private String name;
    private String description;
    private float price;
    private String category;
    private int stock;

    // Costruttore senza id, usato per creare nuovi oggetti da inserire nel database (l'id sarà generato automaticamente)
    public ClothingProduct(String name, String description, float price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = "Clothing";
        this.stock = stock;
    }

    // Costruttore completo, usato per creare oggetti a partire dai dati del database (incluso l'id)
    public ClothingProduct(int id, String name, String description, float price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = "Clothing";
        this.stock = stock;
    }


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }   

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Nome: " + name + "\n" +
               "Descrizione: " + description + "\n" +
               "Prezzo: " + price + "\n" +
               "Categoria: " + category + "\n" +
               "Quantità disponibile: " + stock;
    }
}
