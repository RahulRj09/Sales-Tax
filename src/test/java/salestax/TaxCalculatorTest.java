package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {
    @Test
    public void shouldBeAbleToGetTheImportDutyTaxAmount() {
        double expectedProductsWithTax = 5.0;
        Product product = new Product(Category.BOOK, "java", 100.0, true);
        CartItem cartItem = new CartItem(product,1);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax, taxCalculator.calculate(cartItem),0);
    }

    @Test
    public void shouldBeAbleToGetTheBasicTaxAmount() {
        double expectedProductsWithTax = 10.0;
        Product product = new Product(Category.OTHER, "cd", 100.0, false);
        CartItem cartItem = new CartItem(product,1);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax, taxCalculator.calculate(cartItem),0);
    }

    @Test
    public void ShouldBeAbleToGetBothTypeOfTaxAmount() {
       double expectedProductsWithTax = 15.0;
        Product product = new Product(Category.OTHER, "cd", 100.0, true);
        CartItem cartItem = new CartItem(product,1);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedProductsWithTax, taxCalculator.calculate(cartItem),0);
    }

}