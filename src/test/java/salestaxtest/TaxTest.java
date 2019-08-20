package salestaxtest;

import org.junit.Test;
import salestax.Tax;
import static org.junit.Assert.assertEquals;
public class TaxTest {
    @Test
    public void itShouldBeGiveBasicTaxRateAmount(){
        double expectedTaxAmount = 1.499;
        Tax tax = new Tax();
        assertEquals(expectedTaxAmount,tax.getTax(false,14.99,true),0);
    }

}
