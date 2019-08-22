package salestax;


import java.util.*;

public class TaxCalculator {
    private final double BASIC_TAX_RATE = 0.1;
    private final double IMPORT_DUTY = 0.05;
    private List<String> exemptCategory = Arrays.asList("BOOK", "FOOD", "MEDICAL");
    private Map<Product, Double> items = new HashMap<>();


    public Map<Product, Double> getTax(Map<Product, Integer> products) {
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            double taxAmount = 0;
            if (product.getKey().imported) {
                taxAmount += getTax(product.getKey().price, IMPORT_DUTY);
            }
            if (!exemptCategory.contains(product.getKey().category.toUpperCase())) {
                taxAmount += getTax(product.getKey().price, BASIC_TAX_RATE);
            }
            items.put(product.getKey(), taxAmount);
        }
        return items;
    }
    double getTax(double price, double taxRate) {
        return price * taxRate;
    }
}
