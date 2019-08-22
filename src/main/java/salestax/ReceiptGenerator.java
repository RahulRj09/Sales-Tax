package salestax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {
    private double totalTaxAmount = 0;
    private double totalAllItemsCostAmount = 0;
    private List<Map<String, String>> receipt = new ArrayList<>();

    public void generateReceipt(Map<Product, Double> products, Cart cart) {
        Map<Product, Integer> items = cart.getItems();
        for (Map.Entry<Product, Double> product : products.entrySet()) {
            int quantity = items.get(product.getKey());
            Map<String, String> item = new HashMap<>();
            double price = product.getKey().getPrice() * quantity;
            item.put("category", product.getKey().getCategory());
            item.put("name", product.getKey().getName());
            item.put("imported", String.valueOf(product.getKey().isImported()));
            item.put("price", String.valueOf(costCalculate(product, price)));
            item.put("quantity", String.valueOf(quantity));
            totalTaxAmount += product.getValue();
            totalAllItemsCostAmount += costCalculate(product, price);
            receipt.add(item);
        }
    }

    private double costCalculate(Map.Entry<Product, Double> item, double price) {
        return price + item.getValue();
    }


    public List<Map<String, String>> getReceipt() {
        return receipt;
    }

    public double getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public double getTotalAllItemsCostAmount() {
        return totalAllItemsCostAmount;
    }
}
