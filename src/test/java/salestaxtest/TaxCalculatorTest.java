package salestaxtest;
import org.junit.Test;
import salestax.Cart;
import salestax.Product;
import salestax.TaxCalculator;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
public class TaxCalculatorTest {
    @Test
    public void itShouldBeGiveTheImportedTaxAmount(){
        Map<Product, Double> expectedProductsWithTax = new HashMap<>();
        Product product = new Product("Book", "java", 100.0, true);
        Cart cart = new Cart();
        cart.add(product, 1);
        expectedProductsWithTax.put(product,5.0);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax,taxCalculator.getTax(cart));
    }
}
