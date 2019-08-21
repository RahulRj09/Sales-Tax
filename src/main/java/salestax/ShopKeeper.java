package salestax;

import java.util.HashMap;
import java.util.Map;

public class ShopKeeper {
    Map<Product, Integer> cart = new HashMap<>();

    public void shopKeeper(String category,String name, double price, int quantity, boolean imported) {
        Product product = new Product(category,name,price,imported);
        cart.put(product,quantity);
    }
}
