package model.factory.productFactory;

import model.productModel.Product;

public abstract class ProductFactory {
    abstract public Product createProduct(
            String name,
            String description,
            float price,
            int stock
    );
}
