package salestax;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private List<Product> products = new ArrayList<>();
    private double totalAmount = 0;
    private double totalTax = 0;

    public Factory addProduct(String category, String name, double price, int quontity, boolean imported) {
        Product product = new Product(category, name, price, quontity, imported);
        products.add(product);
        totalAmount += product.getPrice();
        totalTax += product.getTax();
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTotalTax() {
        return totalTax;
    }
}
