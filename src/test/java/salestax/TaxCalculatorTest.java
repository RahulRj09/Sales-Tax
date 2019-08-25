package salestax;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {
    @Test
    public void itShouldBeGiveTheImportedTaxAmount() {
        Map<Product, Double> expectedProductsWithTax = new HashMap<>();
        Product product = new Product(Category.BOOK, "java", 100.0, true);
        Cart cart = new Cart();
        cart.add(product, 1);
        expectedProductsWithTax.put(product, 5.0);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax, taxCalculator.getTaxOfMap(cart));
    }

    @Test
    public void itShouldBeGiveTheBasicTaxAmount() {
        Map<Product, Double> expectedProductsWithTax = new HashMap<>();
        Product product = new Product(Category.OTHER, "cd", 100.0, false);
        Cart cart = new Cart();
        cart.add(product, 1);
        expectedProductsWithTax.put(product, 10.0);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax, taxCalculator.getTaxOfMap(cart));
    }

    @Test
    public void itShouldBeGiveTheBasicTaxAmountAndImportedTaxAmount() {
        Map<Product, Double> expectedProductsWithTax = new HashMap<>();
        Product product = new Product(Category.OTHER, "cd", 100.0, true);
        Cart cart = new Cart();
        cart.add(product, 1);
        expectedProductsWithTax.put(product, 15.0);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax, taxCalculator.getTaxOfMap(cart));
    }

}