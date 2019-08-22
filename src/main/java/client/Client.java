package client;


import salestax.*;

import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Product product = new Product("book", "java", 12.49, false);
        Product product1 = new Product("book", "java", 12.49, true);

        Cart cart = new Cart();
        cart.add(product, 2);
        cart.add(product1, 1);

        CostCalculator costCalculator = new CostCalculator();
        TaxCalculator taxCalculator = new TaxCalculator();
        Map<Product, Double> items = taxCalculator.getTax(costCalculator.costCalculate(cart));

        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        receiptGenerator.generateReceipt(costCalculator.costCalculateWithTax(items), 1);
        List<Map<String, String>> receipt = receiptGenerator.getReceipt();

        for (Map<String, String> aReceipt : receipt) {
            for (Map.Entry<String, String> demo : aReceipt.entrySet()) {
                System.out.print(demo.getKey() + " - " + demo.getValue() + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Sales Tax- " + costCalculator.getTotalTaxAmount());
        System.out.println("Total - " + costCalculator.getTotalAllProductCostAmount());
    }

}
