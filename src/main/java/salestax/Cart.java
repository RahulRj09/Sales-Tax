package salestax;

import java.util.ArrayList;
import java.util.List;


public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();


    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void add(Product product, Integer quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        cartItems.add(cartItem);
    }
}
