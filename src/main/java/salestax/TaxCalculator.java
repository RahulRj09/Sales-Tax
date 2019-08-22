package salestax;


import java.util.*;

public class TaxCalculator {
    private final double BASIC_TAX_RATE = 0.1;
    private final double IMPORT_DUTY = 0.05;
    private List<String> exemptCategory = Arrays.asList("BOOK", "FOOD", "MEDICAL");
    private Map<Product, Double> productsTax = new HashMap<>();


    public Map<Product, Double> getTaxOfMap(Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            double taxAmount = 0;
            Product key = product.getKey();
            double price = key.getPrice() * product.getValue();
            if (key.isImported()) {
                taxAmount += getTax(price, IMPORT_DUTY);
            }
            if (!exemptCategory.contains(key.getCategory().toUpperCase())) {
                taxAmount += getTax(price, BASIC_TAX_RATE);
            }
            productsTax.put(key, taxAmount);
        }
        return productsTax;
    }


    private double getTax(double price, double taxRate) {
        return price * taxRate;
    }
}
