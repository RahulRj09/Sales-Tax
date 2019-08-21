package salestax;

import java.util.Map;

public class ShopKeeper {

    public ShopKeeper shopKeeper(String category, String name, double price, int quantity, boolean imported) {
        Product product = new Product(category, name, price, imported);
        Cart cart = new Cart();
        TaxCalculator taxCalculator = new TaxCalculator();
        Map<Product, Integer> items = cart.add(product, quantity);
        taxCalculator.getTax(items);
        ReceiptGenerator receiptGenerator = new ReceiptGenerator();

        return this;
    }
}
