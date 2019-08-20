package salestaxtest;

import org.junit.Test;
import salestax.Product;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void itShouldBeGiveTaxAmount(){
        double expectedTaxAmount = 1.499;
        Product product = new Product("music", "CD",14.99,1,false,true);
        assertEquals(expectedTaxAmount, product.getTaxAmount(),0);
    }
    @Test
    public void itShouldBeSingleProductPrice(){
        double expectedPriceAmount = 14.99;
        Product product = new Product("music", "CD",14.99,1,false,true);
        assertEquals(expectedPriceAmount, product.getPrice(),0);
    }
}
