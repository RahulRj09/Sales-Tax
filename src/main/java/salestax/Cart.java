package salestax;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public void add(Product product, int quantity) {
        this.products.put(product, quantity);
    }

    public Map<Product,Integer> getProducts() {
        return products;
    }
}
