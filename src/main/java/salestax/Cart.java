package salestax;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void add(Product product, int quantity) {
        this.items.put(product, quantity);
    }

    public Map<Product,Integer> getItems() {
        return items;
    }
}
