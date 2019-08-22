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
            product.put("price", String.valueOf(item.getKey().price));
            product.put("quantity", String.valueOf(quantity));
            receipt.add(product);
        }
    }

    public List<Map<String, String>> getReceipt() {
        return receipt;
    }
}
