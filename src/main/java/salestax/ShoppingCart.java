package salestax;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    private double totalAmount = 0;
    private double totalTaxAmount = 0;

    public ShoppingCart addProduct(String category, String name, double price, int quontity, boolean imported) {
        Product product = new Product(category, name, price, quontity, imported);
        products.add(product);
        totalAmount += product.getPrice();
        totalTaxAmount += product.getTaxAmount();
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTotalTaxAmount() {
        return totalTaxAmount;
    }
}
