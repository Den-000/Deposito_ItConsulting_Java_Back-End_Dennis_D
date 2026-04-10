package model.factory.productFactory;

import model.productModel.HomeProduct;
import model.productModel.Product;

public class HomeFactory extends ProductFactory {

    public Product createProduct(String name, String description, float price, int stock) {
        return new HomeProduct(name, description, price, stock);
    }
    
}
