package salestax;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private List<Product> products = new ArrayList<>();

    public Factory addProduct(String category, String name, double price, int quontity, boolean imported) {
        Product product = new Product(category, name, price, quontity, imported);
        products.add(product);
        System.out.println(product.getPrice());
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }
}
