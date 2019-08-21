package salestax;

public class Product {
    public String category;
    public String name;
    public double price;
    public boolean imported;

    public Product(String category, String name, double price, boolean imported) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.imported = imported;
    }
}