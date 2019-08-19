package client;

import salestax.Product;

public class Client {
    public static void main(String[] args) {
        Product product = new Product("book","java",20,2);
        System.out.println(product.name);
        System.out.println(product.getPrice());
    }
}
