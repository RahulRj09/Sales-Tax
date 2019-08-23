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
            double price = product.getKey().getPrice() * quantity;
            receipt.add(getReceiptItemDetails(product, quantity, price));
            totalTaxAmount += product.getValue();
            totalAllItemsCostAmount += calculateCost(product.getValue(), price);
        }
    }

    private Map<String, String> getReceiptItemDetails(Map.Entry<Product, Double> product, int quantity, double price) {
        Product key = product.getKey();
        Map<String, String> item = new HashMap<>();
        item.put("category", key.getCategory().name());
        item.put("name", key.getName());
        item.put("imported", String.valueOf(key.isImported()));
        item.put("price", String.valueOf(calculateCost(product.getValue(), price)));
        item.put("quantity", String.valueOf(quantity));
        return item;
    }

    private double calculateCost(Double tax, double price) {
        return price + tax;
    }

    public void print() {
        for (Map<String, String> aReceipt : this.receipt) {
            for (Map.Entry<String, String> item : aReceipt.entrySet()) {
                System.out.print(item.getKey() + " - " + item.getValue() + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Sales Tax - " + this.totalTaxAmount);
        System.out.println("Total - " + this.totalAllItemsCostAmount);
    }

}
