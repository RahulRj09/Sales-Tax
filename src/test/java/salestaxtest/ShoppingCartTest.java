package salestaxtest;

import org.junit.Test;
import salestax.ShoppingCart;
import salestax.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    @Test
    public void productShouldBeAdd() {
        List<Product> expectedProduct = new ArrayList<>();
        Product product = new Product("BOOK", "java", 20.0, false);
        expectedProduct.add(product);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct("BOOK", "java", 20.0, 1, false, false);
        assertEquals(expectedProduct, shoppingCart.getProducts());
    }

    @Test
    public void itShouldBeGiveTotalAmount() {
        double expectedTotalAmount = 34.99;
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct("music", "CD", 14.99, 1, false, false);
        shoppingCart.addProduct("BOOK", "java", 20.0, 1, false, false);
        assertEquals(expectedTotalAmount, shoppingCart.getTotalAmount(), 0);
    }

    @Test
    public void itShouldBeGiveTotalTaxAmount() {
        double expectedTotalTaxAmount = 1.499;
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct("music", "CD", 14.99, 1, false, true);
        assertEquals(expectedTotalTaxAmount, shoppingCart.getTotalTaxAmount(), 0);
    }
}
