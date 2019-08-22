package salestax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {
    double totalTaxAmount = 0;
    double totalAllItemsCostAmount = 0;
    private List<Map<String, String>> receipt = new ArrayList<>();

    public void generateReceipt(Map<Product, Double> itemsWithTax, Cart cart) {
        Map<Product, Integer> items = cart.getItems();
        for (Map.Entry<Product, Double> itemWithTax : itemsWithTax.entrySet()) {
            int quantity = items.get(itemWithTax.getKey());
            Map<String, String> item = new HashMap<>();
            item.put("name", itemWithTax.getKey().getName());
            item.put("category", itemWithTax.getKey().getCategory());
            item.put("imported", String.valueOf(itemWithTax.getKey().isImported()));
            double price = getPrice(quantity, itemWithTax);
            item.put("price", String.valueOf(getPriceWithTax(itemWithTax, price)));
            item.put("quantity", String.valueOf(quantity));
            totalTaxAmount +=itemWithTax.getValue();
            totalAllItemsCostAmount+=getPriceWithTax(itemWithTax, price);
            receipt.add(item);
        }
    }

    private double getPriceWithTax(Map.Entry<Product, Double> item, double price) {
        return price+item.getValue();
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
