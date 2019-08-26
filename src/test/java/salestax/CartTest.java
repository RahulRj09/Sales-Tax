package salestax;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CartTest {
    @Test
    public void shouldBeAbleToAddProductInCart() {
       List<CartItem> expectedProducts = new ArrayList<>();
        Product product = new Product(Category.BOOK, "java", 100.0, false);
        Cart cart = new Cart();
        CartItem cartItem = new CartItem(product,1);
        cart.add(product,1);
        expectedProducts.add(cartItem);
        assertEquals(expectedProducts, cart.getCartItems());
    }
}
