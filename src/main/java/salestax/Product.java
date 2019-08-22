package salestax;

public class Product {
    private String category;
    private String name;
    private double price;
    private boolean imported;

    public Product(String category, String name, double price, boolean imported) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.imported = imported;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return imported;
    }
}