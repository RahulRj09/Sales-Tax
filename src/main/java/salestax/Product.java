package salestax;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Product {
    private String category;
    private String name;
    private double price;
    private int quontity;
    private boolean imported;
    public List productCategory = Arrays.asList(ProductCategory.values());
    final int BASIC_TAX_RATE = 10;
    final int IMPORT_DUTY = 5;

    public Product(String category, String name, double price, int quontity, boolean imported) {
        this.category = category.toUpperCase();
        this.name = name;
        this.price = price;
        this.quontity = quontity;
        this.imported = imported;
    }

    double getPrice() {
        return getPrice(imported);
    }

    private double getPrice(boolean imported) {
        if (imported) {
            return getPrice(price + (IMPORT_DUTY * price) / 100);
        }
        return getPrice(price * quontity);
    }

    private double getPrice(double price) {
        if (productCategory.contains(category)) {
            return price;
        }
        return price + (BASIC_TAX_RATE * price) / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                quontity == product.quontity &&
                imported == product.imported &&
                Objects.equals(category, product.category) &&
                Objects.equals(name, product.name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", name=" + name +
                ", price=" + price +
                ",quontity=" + quontity +
                '}';
    }
}
