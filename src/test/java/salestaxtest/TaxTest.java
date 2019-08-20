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
    @Test
    public void itShouldBeGiveImportDutyTaxAmount(){
        double expectedImportDutyTaxAmount =0.7495;
        Tax tax = new Tax();
        assertEquals(expectedImportDutyTaxAmount,tax.getTax(true,14.99,false),0);
    }
}
