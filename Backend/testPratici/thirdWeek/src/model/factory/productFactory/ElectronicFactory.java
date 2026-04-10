package model.factory.productFactory;

import model.productModel.ElectronicProduct;
import model.productModel.Product;

public class ElectronicFactory extends ProductFactory {

    public Product createProduct(String name, String description, float price, int stock) {
        return new ElectronicProduct(name, description, price, stock);
    }
    
}
