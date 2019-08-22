package client;


import salestax.*;

import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Product product = new Product("book", "java", 12, false);
        Product product1 = new Product("book", "java", 12, true);

        Cart cart = new Cart();
        cart.add(product, 4);
        cart.add(product1, 2);

        TaxCalculator taxCalculator = new TaxCalculator();
        Map<Product, Double> products = taxCalculator.getTax(cart);

        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        receiptGenerator.generateReceipt(products, cart);

        List<Map<String, String>> receipt = receiptGenerator.getReceipt();

        for (Map<String, String> aReceipt : receipt) {
            for (Map.Entry<String, String> demo : aReceipt.entrySet()) {
                System.out.print(demo.getKey() + " - " + demo.getValue() + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Sales Tax - " + receiptGenerator.getTotalTaxAmount());
        System.out.println("Total - " + receiptGenerator.getTotalAllItemsCostAmount());
    }

}