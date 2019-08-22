package client;


import salestax.*;

import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Product product = new Product("book", "java", 12, false);
        Product product1 = new Product("book", "java", 12, true);

        Cart cart = new Cart();
        cart.add(product, 4);
        cart.add(product1, 2);

        TaxCalculator taxCalculator = new TaxCalculator();
        Map<Product, Double> productsTax = taxCalculator.getTaxOfMap(cart);

        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        receiptGenerator.generateReceipt(productsTax, cart);
        receiptGenerator.receiptPrinter();
    }
}