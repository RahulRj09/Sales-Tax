package salestax;

import java.util.ArrayList;
import java.util.List;

public class ReceiptGenerator {
    private TaxCalculator taxCalculator;

    public ReceiptGenerator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public Receipt generateReceipt(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        double totalTaxAmount = 0;
        double totalAllItemsCostAmount = 0;
        List<ReceiptItem> receiptItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            double price = cartItem.getPrice();
            double calculatedTax = taxCalculator.calculate(cartItem);
            totalTaxAmount += calculatedTax;
            totalAllItemsCostAmount += price;
            ReceiptItem receiptItem = new ReceiptItem(cartItem, price, calculatedTax);
            receiptItems.add(receiptItem);
        }
        Receipt receipt = new Receipt(receiptItems, totalTaxAmount, totalAllItemsCostAmount);
        return receipt;
    }


}
