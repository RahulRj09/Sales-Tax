package salestax;


import java.util.*;

public class TaxCalculator {
    private final double BASIC_TAX_RATE = 0.1;
    private final double IMPORT_DUTY = 0.05;
    private List<Category> category = Arrays.asList(Category.BOOK, Category.FOOD, Category.MEDICAL);

    public double calculate(CartItem cartItem) {
        Product product = cartItem.getProduct();
        double taxes = 0;
        double price = cartItem.getPrice();
        if (product.isImported()) {
            taxes += getTax(price, IMPORT_DUTY);
        }
        if (!category.contains(product.getCategory())) {
            taxes += getTax(price, BASIC_TAX_RATE);
        }
        return taxes;
    }

    private double getTax(double price, double taxRate) {
        return price * taxRate;
    }

}
