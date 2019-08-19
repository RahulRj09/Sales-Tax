package client;

import salestax.Product;
import salestax.ProductFactory;

public class Client {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();
        productFactory.addProduct("book","java",20.0,1);
        productFactory.addProduct("medical", "ac lock 300",2.50,5);
        for (Product product: productFactory.getProducts()){
            System.out.println(product);
        }
    }
}
