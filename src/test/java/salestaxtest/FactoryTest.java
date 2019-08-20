package salestaxtest;

import org.junit.Test;
import salestax.Factory;
import salestax.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class FactoryTest {
    @Test
    public void productShouldBeAdd(){
        List<Product> expectedProduct = new ArrayList<>();
        Product product = new Product("BOOK","java",20.0,1,false);
        expectedProduct.add(product);
        Factory factory = new Factory();
        factory.addProduct("BOOK","java",20.0,1,false);
        assertEquals(expectedProduct,factory.getProducts());
    }
}
