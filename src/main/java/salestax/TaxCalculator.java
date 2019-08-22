package salestax;


import java.util.*;

public class TaxCalculator {
    private final double BASIC_TAX_RATE = 0.1;
    private final double IMPORT_DUTY = 0.05;
    private List<String> exemptCategory = Arrays.asList("BOOK", "FOOD", "MEDICAL");
    private Map<Product, Double> itemsWithTax = new HashMap<>();


    public Map<Product, Double> getTax(Cart cart) {
        Map<Product, Integer> items = cart.getItems();
        for (Map.Entry<Product, Integer> item : items.entrySet()) {
            double taxAmount = 0;
            double price = getPrice(item);
            if (item.getKey().imported) {
                taxAmount += getTax(price, IMPORT_DUTY);
                System.out.println(taxAmount);
            }
            if (!exemptCategory.contains(item.getKey().category.toUpperCase())) {
                taxAmount += getTax(price, BASIC_TAX_RATE);
            }
           itemsWithTax.put(item.getKey(), taxAmount);
        }
        return itemsWithTax;
    }

    private double getPrice(Map.Entry<Product, Integer> item) {
        return item.getKey().price * item.getValue();
    }

    private double getTax(double price, double taxRate) {
        return price * taxRate;
    }
}
