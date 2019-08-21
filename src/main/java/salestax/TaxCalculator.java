package salestax;


import java.util.*;

public class TaxCalculator {
    private final int BASIC_TAX_RATE = 10;
    private final int IMPORT_DUTY = 5;
    private Set<String> exemptCategory = new HashSet<>(Arrays.asList("book", "food", "medical"));

    public Map<Product, Double> getTax(Map<Product, Integer> cart) {
        Map<Product, Double> totalTaxAmount = new HashMap<>();
        for (Map.Entry<Product, Integer> c : cart.entrySet()) {
            double taxAmount = 0;
            double price = c.getValue() * c.getKey().price;
            if (c.getKey().imported) {
                taxAmount += getTax(price, IMPORT_DUTY);
            }
            if (!exemptCategory.toString().contains(c.getKey().category)) {
                taxAmount += getTax(price, BASIC_TAX_RATE);
            }
            totalTaxAmount.put(c.getKey(), taxAmount);
        }
        return totalTaxAmount;
    }

    double getTax(double price, int taxRate) {
        return (price * taxRate) / 100;
    }
}
