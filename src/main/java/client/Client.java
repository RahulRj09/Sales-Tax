package client;


import salestax.*;


public class Client {
    public static void main(String[] args) {
        Product product = new Product(Category.FOOD, "java", 12, false);
        Product product1 = new Product(Category.FOOD, "java", 12, true);
        Product product2 = new Product(Category.OTHER, "CD", 14.99, true);

        Cart cart = new Cart();
        cart.add(product, 4);
        cart.add(product1, 2);
        cart.add(product2, 1);

        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        receiptGenerator.generateReceipt(cart);
        receiptGenerator.print();
    }
}