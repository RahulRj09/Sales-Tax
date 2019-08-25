package salestax;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CartTest {
    @Test
    public void shouldBeAbleToAddProductInCart() {
        Map<Product, Integer> expectedProducts = new HashMap<>();
        Product product = new Product(Category.BOOK, "java", 100.0, false);
        Cart cart = new Cart();
        cart.add(product, 1);
        expectedProducts.put(product, 1);
        assertEquals(expectedProducts, cart.getProducts());
    }
}
