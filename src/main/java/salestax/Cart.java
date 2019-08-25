package salestax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> products = new HashMap<>();
    private List<CartItem> cartItems = new ArrayList<>();

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void add(Product product, Integer quantity) {
        products.put(product, quantity);
        CartItem cartItem = new CartItem(product, quantity);
        cartItems.add(cartItem);
    }
}
