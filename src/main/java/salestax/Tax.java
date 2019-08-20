package salestax;


import java.util.Arrays;
import java.util.List;

public class Tax {
    private final int BASIC_TAX_RATE = 10;
    private final int IMPORT_DUTY = 5;
    private List<ProductCategory> productCategory = Arrays.asList(ProductCategory.values());

    public double getPrice(boolean imported, double price, String category) {
        if (imported) {
            return getPrice(price + (IMPORT_DUTY * price) / 100, category);
        }
        return getPrice(price, category);
    }

    private double getPrice(double price, String category) {
        if (productCategory.toString().contains(category)) {
            return price;
        }
        return price + (BASIC_TAX_RATE * price) / 100;
    }

}
