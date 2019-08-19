package salestax;

import java.util.Arrays;
import java.util.List;

enum ProductCategory {
    BOOK, FOOD, MEDICAL
}

public class Product {
    private String category;
    private String name;
    private double price;
    private int quontity;
    private boolean imported;
    List productCategory = Arrays.asList(ProductCategory.values());

    public Product(String category, String name, double price, int quontity, boolean imported) {
        this.category = category.toUpperCase();
        this.name = name;
        this.price = price;
        this.quontity = quontity;
        this.imported = imported;
    }

    public double getPrice() {
        return price * quontity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category + '\'' +
                ", name=" + name +
                ", price=" + price +
                ",quontity=" + quontity +
                '}';
    }
}
