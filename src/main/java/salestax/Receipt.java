package salestax;

import java.util.List;

public class Receipt {
    private List<ReceiptItem> receiptItems;
    private double totalTaxAmount;
    private double totalAllItemsCostAmount;

    public Receipt(List<ReceiptItem> receiptItems, double totalTaxAmount, double totalAllItemsCostAmount) {
        this.receiptItems = receiptItems;
        this.totalTaxAmount = totalTaxAmount;
        this.totalAllItemsCostAmount = totalAllItemsCostAmount;
    }

    public void print(){
        for (ReceiptItem receiptItem : receiptItems){
            System.out.printf("%20s   %5d   %10f   %10f   %10f\n",
                    receiptItem.getCartItem().getProduct().getName()
                    , receiptItem.getCartItem().getQuantity()
                    , receiptItem.getCartItem().getProduct().getPrice()
                    ,receiptItem.getTax()
                    ,receiptItem.getPrice() +receiptItem.getTax());
        }
        System.out.printf("%67s\n", "-----------------------------------------------------");
        System.out.printf("%20s   %5s   %10f   %10f   %10f",
                ""
                , ""
                ,totalAllItemsCostAmount
                ,totalTaxAmount
                ,(totalTaxAmount + totalAllItemsCostAmount));

    }
}
