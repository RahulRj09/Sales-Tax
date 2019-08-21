package salestax;

import java.util.HashMap;
import java.util.Map;

public class ShopKeeper {
    private Map<Product, Integer> cart = new HashMap<>();

    public ShopKeeper shopKeeper(String category,String name, double price, int quantity, boolean imported) {
        Product product = new Product(category,name,price,imported);
        cart.put(product,quantity);
        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.getTax(cart);
        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        return this;
    }
}
