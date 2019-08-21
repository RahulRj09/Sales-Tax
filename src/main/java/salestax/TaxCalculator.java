package salestax;


public class TaxCalculator {
    private final int BASIC_TAX_RATE = 10;
    private final int IMPORT_DUTY = 5;
    private double taxAmount = 0;

    public double getTax(boolean imported, double price, boolean taxable) {
        if (imported) {
            taxAmount += IMPORT_DUTY * price / 100;
        }
        return getTax(price, taxable);
    }

    private double getTax(double price, boolean taxable) {
        if (taxable) {
            taxAmount += ((BASIC_TAX_RATE * price) / 100);
        }
        return taxAmount;

    }

}