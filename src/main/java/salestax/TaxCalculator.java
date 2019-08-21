package salestax;


import java.util.*;

public class TaxCalculator {
    private final int BASIC_TAX_RATE = 10;
    private final int IMPORT_DUTY = 5;
    private List<String> exemptCategory = Arrays.asList("BOOK", "FOOD", "MEDICAL");
    private Map<Product, Double> items = new HashMap<>();

    public Map<Product, Double> getItems() {
        return items;
    }

    public void getTax(Cart cart) {

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
    }

    private double getPrice(Map.Entry<Product, Integer> item) {
        return item.getValue() * item.getKey().price;
    }

    double getTax(double price, int taxRate) {
        return (price * taxRate) / 100;
    }
}
