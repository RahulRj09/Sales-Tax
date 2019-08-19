package salestax;

public class Product {
    private String category;
    public String name;
    private double price;
    private int quontity;

    public Product(String category,String name, double price, int quontity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quontity = quontity;
    }

    public double getPrice() {
        return price * quontity;
    }
}
