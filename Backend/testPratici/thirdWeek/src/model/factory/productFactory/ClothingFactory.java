package model.factory.productFactory;

import model.productModel.*;

public class ClothingFactory extends ProductFactory {

    public Product createProduct(
            String name,
            String description,
            float price,
            int stock
    ) {
        return new ClothingProduct(name, description, price, stock);
    }
}