package salestax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {

    private List<Map<String, String>> receipt = new ArrayList<>();

    public void generateReceipt(Map<Product, Double> items, int quantity) {
        for (Map.Entry<Product, Double> item : items.entrySet()) {
            Map<String, String> product = new HashMap<>();
            product.put("name", item.getKey().name);
            product.put("category", item.getKey().category);
            product.put("imported", String.valueOf(item.getKey().imported));
            double price = getPrice(quantity, item);
            product.put("price", String.valueOf(getPriceWithTax(item, price)));
            product.put("quantity", String.valueOf(quantity));
            receipt.add(product);
        }
    }

    private double getPriceWithTax(Map.Entry<Product, Double> item, double price) {
        return price+item.getValue();
    }

    private double getPrice(int quantity, Map.Entry<Product, Double> item) {
        return item.getKey().price * quantity;

    }

    public List<Map<String, String>> getReceipt() {
        return receipt;
    }
}
