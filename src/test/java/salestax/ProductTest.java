package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void itShouldBeGiveTheNameOfProduct() {
        String expected = "CD";
        Product product = new Product("music", "CD", 14.99, false);
        assertEquals(expected, product.getName());
    }

}