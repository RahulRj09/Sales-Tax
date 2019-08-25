package salestax;


import java.util.*;

public class TaxCalculator {
    private final double BASIC_TAX_RATE = 0.1;
    private final double IMPORT_DUTY = 0.05;
    private List<Category> category = Arrays.asList(Category.BOOK, Category.FOOD, Category.MEDICAL);
    private Map<Product, Double> productsTax = new HashMap<>();

    public Map<Product, Double> getTaxOfMap(Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            Product key = product.getKey();
            double price = key.getPrice() * product.getValue();
            double taxAmount = getTaxAmount(key, price);
            productsTax.put(key, taxAmount);
        }
        return productsTax;
    }

    private double getTaxAmount(Product key, double price) {
        double taxAmount = 0;

        if (key.isImported()) {
            taxAmount += calculateTax(price, IMPORT_DUTY);
        }
        if (!isTaxable(key)) {
            taxAmount += calculateTax(price, BASIC_TAX_RATE);
        }
        return taxAmount;
    }

    private boolean isTaxable(Product key) {
        return category.toString().contains(key.getCategory().name());
    }

    private double calculateTax(double price, double taxRate) {
        return price * taxRate;
    }
}
