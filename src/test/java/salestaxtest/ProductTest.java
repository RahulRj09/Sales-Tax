package salestaxtest;

import org.junit.Test;
import salestax.Product;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void itShouldBeGiveTaxAmount(){
        double expectedTotalTaxAmount = 1.499;
        Product product = new Product("music", "CD",14.99,1,false,true);
        assertEquals(expectedTotalTaxAmount, product.getTaxAmount(),0);
    }
    @Test
    public void itShouldBeSingleProductPrice(){
        double expectedTotalTaxAmount = 14.99;
        Product product = new Product("music", "CD",14.99,1,false,true);
        assertEquals(expectedTotalTaxAmount, product.getPrice(),0);
    }
}
