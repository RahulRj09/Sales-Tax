package client;


import salestax.Cart;
import salestax.Product;
import salestax.ReceiptGenerator;
import salestax.TaxCalculator;

import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Product product = new Product("book", "java", 12.49, false);
        Product product1 = new Product("book", "java", 12.49, true);

        Cart cart = new Cart();
        cart.add(product, 1);
        cart.add(product1, 1);
        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.getTax(cart);

        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        receiptGenerator.generateReceipt(taxCalculator, 1);
        List<Map<String, String>> receipt = receiptGenerator.getReceipt();

        for (Map<String, String> aReceipt : receipt) {
            for (Map.Entry<String, String> demo : aReceipt.entrySet()) {
                System.out.print(demo.getKey() + " - " + demo.getValue()+" ");
            }
            System.out.println("\n");
        }

    }
}
