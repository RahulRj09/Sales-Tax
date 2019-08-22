package salestax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {
    double totalTaxAmount = 0;
    double totalAllItemsCostAmount = 0;
    private List<Map<String, String>> receipt = new ArrayList<>();

    public void generateReceipt(Map<Product, Double> products, Cart cart) {
        Map<Product, Integer> items = cart.getItems();
        for (Map.Entry<Product, Double> product : products.entrySet()) {
            int quantity = items.get(product.getKey());
            Map<String, String> item = new HashMap<>();
            item.put("category", product.getKey().getCategory());
            item.put("name", product.getKey().getName());
            item.put("imported", String.valueOf(product.getKey().isImported()));
            double price = getPrice(quantity, product);
            item.put("price", String.valueOf(getPriceWithTax(product, price)));
            item.put("quantity", String.valueOf(quantity));
            totalTaxAmount += product.getValue();
            totalAllItemsCostAmount += getPriceWithTax(product, price);
            receipt.add(item);
        }
    }

    private double getPriceWithTax(Map.Entry<Product, Double> item, double price) {
        return price + item.getValue();
    }

    private double getPrice(int quantity, Map.Entry<Product, Double> item) {
        return item.getKey().getPrice() * quantity;

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
