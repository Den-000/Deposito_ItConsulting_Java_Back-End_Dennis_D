package model.productModel;

public interface Product {

    // TODO: implementare dei decorator per i prodotti, in modo da poter aggiungere funzionalità extra (es. sconti, offerte, etc.) senza dover modificare la classe BaseProduct
    int getId();

    String getName();

    String getDescription();

    float getPrice();

    String getCategory();

    int getStock();

    public void setId(int id);

    public void setName(String name);

    public void setDescription(String description);

    public void setPrice(float price);

    public void setCategory(String category);

    public void setStock(int stock);
    
}
