package salestax;


public class Tax {
    private final int BASIC_TAX_RATE = 10;
    private final int IMPORT_DUTY = 5;
    private double totalTax = 0;

    double getTax(boolean imported, double price, boolean taxable) {
        if (imported) {
            totalTax += (IMPORT_DUTY * price) / 100;
            return getTax(price, taxable);
        }
        return getTax(price, taxable);
    }

    private double getTax(double price, boolean taxable) {
        if (taxable) {
            return totalTax + (BASIC_TAX_RATE * price) / 100;
        }
        return totalTax;

    }

}
