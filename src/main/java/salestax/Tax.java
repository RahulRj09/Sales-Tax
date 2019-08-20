package salestax;


import java.util.Arrays;
import java.util.List;

public class Tax {
    private final int BASIC_TAX_RATE = 10;
    private final int IMPORT_DUTY = 5;
    private List<ExemptProductCategory> exemptProductCategory = Arrays.asList(ExemptProductCategory.values());
    private double totalTax = 0;

    public double getTax(boolean imported, double price, String category) {
        if (imported) {
            return getTax(totalTax + (IMPORT_DUTY * price) / 100, category);
        }
        return getTax(price, category);
    }

    private double getTax(double price, String category) {
        if (exemptProductCategory.toString().contains(category)) {
            return totalTax;
        }
        return totalTax + (BASIC_TAX_RATE * price) / 100;
    }

}
