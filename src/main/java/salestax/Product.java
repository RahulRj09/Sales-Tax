package salestax;

public class Product {
    String category;
    public String name;
    double price;
    int quontity;

    public Product(String category,String name, double price, int quontity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quontity = quontity;
    }
}
