package salestax;

import java.util.Arrays;
import java.util.List;

public class Tax {
    public List productCategory = Arrays.asList(ProductCategory.values());
    final int BASIC_TAX_RATE = 10;
    final int IMPORT_DUTY = 5;

    public double getPrice(boolean imported, double price, String category) {
        return price;
    }


}
