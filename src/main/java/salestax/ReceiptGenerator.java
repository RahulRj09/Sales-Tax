package salestax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {

    public double totalTaxAmount = 0;
    public double totalPriceAmount = 0;
    private List<Map<String, String>> receipt = new ArrayList<>();

    public void generateReceipt(TaxCalculator taxCalculator, int quantity) {
        Map<Product, Double> items = taxCalculator.getItems();
        for (Map.Entry<Product, Double> item : items.entrySet()) {
            Map<String, String> product = new HashMap<>();
            product.put("name", item.getKey().name);
            product.put("category", item.getKey().category);
            product.put("imported", String.valueOf(item.getKey().imported));
            double price = getTotalPrice(quantity, item);
            product.put("price", String.valueOf(price));
            product.put("quantity", String.valueOf(quantity));
            this.totalTaxAmount += item.getValue();
            this.totalPriceAmount += price;
            receipt.add(product);
        }
    }

    public List<Map<String, String>> getReceipt() {
        return receipt;
    }

    private double getTotalPrice(int quantity, Map.Entry<Product, Double> item) {
        double price = (item.getKey().price * quantity) + item.getValue();
        return price;
    }
}
