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
        Product product = new Product("Book", "java", 200.0, true);
        Cart cart = new Cart();
        cart.add(product, 2);
        expectedProductsWithTax.put(product,10.0);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax,taxCalculator.getTax(cart.getItems()));
    }
    @Test
    public void itShouldBeGiveTheBasicTaxAmount(){
        Map<Product, Double> expectedProductsWithTax = new HashMap<>();
        Product product = new Product("music", "cd", 100.0, false);
        Cart cart = new Cart();
        cart.add(product, 1);
        expectedProductsWithTax.put(product,10.0);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax,taxCalculator.getTax(cart.getItems()));
    }
     @Test
    public void itShouldBeGiveTheBasicTaxAmountAndImportedTaxAmountSameTime(){
        Map<Product, Double> expectedProductsWithTax = new HashMap<>();
        Product product = new Product("music", "cd", 100.0, true);
        Cart cart = new Cart();
        cart.add(product, 1);
        expectedProductsWithTax.put(product,15.0);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax,taxCalculator.getTax(cart.getItems()));
    }

}
