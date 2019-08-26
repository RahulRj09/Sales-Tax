package salestax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {
    private double totalTaxAmount = 0;
    private double totalAllItemsCostAmount = 0;
    private List<Map<String, String>> receipt = new ArrayList<>();

    public void generateReceipt(Cart cart) {

        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            double price = cartItem.getPrice();
            TaxCalculator taxCalculator = new TaxCalculator();
            double calculatedTax = taxCalculator.calculate(cartItem);
            totalTaxAmount += calculatedTax;
            totalAllItemsCostAmount += calculateCost(calculatedTax, price);
            receipt.add(getReceiptItemDetails(cartItem, calculatedTax, price));
        }
    }

    private Map<String, String> getReceiptItemDetails(CartItem cartItem, double calculatedTax, double price) {
        Map<String, String> item = new HashMap<>();
        Product product = cartItem.getProduct();
        item.put("category", String.valueOf(product.getCategory()));
        item.put("name", product.getName());
        item.put("imported", String.valueOf(product.isImported()));
        item.put("price", String.valueOf(calculateCost(calculatedTax, price)));
        item.put("quantity", String.valueOf(cartItem.getQuantity()));
        return item;
    }

    private double calculateCost(Double tax, double price) {
        return price + tax;
    }

    public void print() {
        for (Map<String, String> aReceipt : this.receipt) {
            for (Map.Entry<String, String> item : aReceipt.entrySet()) {
                System.out.print(item.getKey() + " - " + item.getValue() + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Sales Tax - " + this.totalTaxAmount);
        System.out.println("Total - " + this.totalAllItemsCostAmount);
    }

}
