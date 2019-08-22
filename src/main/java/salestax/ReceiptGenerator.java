package salestax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {
    private double totalTaxAmount = 0;
    private double totalAllItemsCostAmount = 0;
    private List<Map<String, String>> receipt = new ArrayList<>();

    public void generateReceipt(Map<Product, Double> productsTax, Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Double> product : productsTax.entrySet()) {
            int quantity = products.get(product.getKey());
            Map<String, String> item = new HashMap<>();
            double price = product.getKey().getPrice() * quantity;
            item.put("category", product.getKey().getCategory());
            item.put("name", product.getKey().getName());
            item.put("imported", String.valueOf(product.getKey().isImported()));
            item.put("price", String.valueOf(calculateCost(product.getValue(), price)));
            item.put("quantity", String.valueOf(quantity));
            totalTaxAmount += product.getValue();
            totalAllItemsCostAmount += calculateCost(product.getValue(), price);
            receipt.add(item);
        }
    }

    public void receiptPrinter() {
        for (Map<String, String> aReceipt : this.receipt) {
            for (Map.Entry<String, String> item : aReceipt.entrySet()) {
                System.out.print(item.getKey() + " - " + item.getValue() + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Sales Tax - " + this.totalTaxAmount);
        System.out.println("Total - " + this.totalAllItemsCostAmount);
    }

    private double calculateCost(Double tax, double price) {
        return price + tax;
    }

}
