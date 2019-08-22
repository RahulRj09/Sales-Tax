package salestax;


import java.util.*;

public class TaxCalculator {
    private final double BASIC_TAX_RATE = 0.1;
    private final double IMPORT_DUTY = 0.05;
    private List<String> exemptCategory = Arrays.asList("BOOK", "FOOD", "MEDICAL");
    private Map<Product, Double> items = new HashMap<>();


    public Map<Product, Double> getTax(Cart cart) {

        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            double taxAmount = 0;
            double price = getPrice(product);
            if (product.getKey().imported) {
                taxAmount += getTax(price, IMPORT_DUTY);
            }
            if (!exemptCategory.contains(product.getKey().category.toUpperCase())) {
                taxAmount += getTax(price, BASIC_TAX_RATE);
            }
            items.put(product.getKey(), taxAmount);
        }
        return items;
    }

    private double getPrice(Map.Entry<Product, Integer> item) {
        return item.getValue() * item.getKey().price;
    }

    double getTax(double price, double taxRate) {
        return price * taxRate;
    }
}
