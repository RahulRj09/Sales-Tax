package salestaxtest;

import org.junit.Test;
import salestax.TaxCalculator;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {
    @Test
    public void itShouldBeGiveBasicTaxRateAmount() {
        double expectedTaxAmount = 1.499;
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedTaxAmount, taxCalculator.getTax(false, 14.99, true), 0);
    }

    @Test
    public void itShouldBeGiveImportDutyTaxAmount() {
        double expectedImportDutyTaxAmount = 0.7495;
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedImportDutyTaxAmount, taxCalculator.getTax(true, 14.99, false), 0);
    }

    @Test
    public void itShouldBeGiveBasicTaxRateAmountAndImportDutyTaxAmount() {
        double expectedTotalTaxAmount = 2.2485;
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(expectedTotalTaxAmount, taxCalculator.getTax(true, 14.99, true), 0);
    }

}
