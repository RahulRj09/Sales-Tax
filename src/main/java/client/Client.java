package client;


import salestax.ShopKeeper;


public class Client {
    public static void main(String[] args) {
        ShopKeeper shopKeeper = new ShopKeeper();
        shopKeeper.shopKeeper("book", "java", 12.49, 1, false);
        shopKeeper.shopKeeper("book", "C#", 15.0, 1, true);
    }
}
