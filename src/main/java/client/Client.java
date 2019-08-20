package client;

import salestax.Product;
import salestax.Factory;

public class Client {
    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.addProduct("book", "java", 12.49, 1, false);
        factory.addProduct("food", "chocolate bar", 0.85, 1, false);
        factory.addProduct("music", "CD",14.99,1,false);
        for (Product product : factory.getProducts()) {
            System.out.println(product);
        }

    }
}
