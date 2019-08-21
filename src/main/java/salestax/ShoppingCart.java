package salestax;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    private double totalAmount = 0;
    private double totalTaxAmount = 0;

    public ShoppingCart addProduct(String category, String name, double price, int quontity, boolean imported, boolean taxable) {
        Product product = new Product(category, name, price, imported);
        products.add(product);
        totalTaxAmount += product.getTaxAmount();
        totalAmount += product.getPrice();
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
