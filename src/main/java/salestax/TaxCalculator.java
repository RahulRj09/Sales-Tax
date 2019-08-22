package salestax;


import java.util.*;

public class TaxCalculator {
    private final double BASIC_TAX_RATE = 0.1;
    private final double IMPORT_DUTY = 0.05;
    private List<String> exemptCategory = Arrays.asList("BOOK", "FOOD", "MEDICAL");
    private Map<Product, Double> productsTax = new HashMap<>();


    public Map<Product, Double> getTax(Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> item : products.entrySet()) {
            double taxAmount = 0;
            double price = item.getKey().getPrice() * item.getValue();
            if (item.getKey().isImported()) {
                taxAmount += getTax(price, IMPORT_DUTY);
            }
            if (!exemptCategory.contains(item.getKey().getCategory().toUpperCase())) {
                taxAmount += getTax(price, BASIC_TAX_RATE);
            }
            productsTax.put(item.getKey(), taxAmount);
        }
        return productsTax;
    }


    private double getTax(double price, double taxRate) {
        return price * taxRate;
    }
}
