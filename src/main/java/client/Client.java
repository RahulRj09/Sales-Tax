package client;

import salestax.Product;
import salestax.ShoppingCart;

public class Client {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct("book", "java", 12.49, 1, false);
        shoppingCart.addProduct("food", "chocolate bar", 0.85, 1, false);
        shoppingCart.addProduct("music", "CD",14.99,1,false);
        for (Product product : shoppingCart.getProducts()) {
            System.out.println(product);
        }
        System.out.println("Sales Tax - "+ shoppingCart.getTotalTaxAmount());
        System.out.println("Total - "+ shoppingCart.getTotalAmount());
    }
}
