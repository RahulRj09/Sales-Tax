package salestax;

public class Product {
    private Category category;
    private String name;
    private double price;
    private boolean imported;

    public Product(Category category, String name, double price, boolean imported) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.imported = imported;
    }

    public Category getCategory() {
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