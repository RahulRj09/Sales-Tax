package salestax;

import java.util.Objects;

public class Product {
    private String category;
    private String name;
    private double price;
    private int quontity;
    private boolean imported;

    public Product(String category, String name, double price, int quontity, boolean imported) {
        this.category = category.toUpperCase();
        this.name = name;
        this.price = price;
        this.quontity = quontity;
        this.imported = imported;
    }

    double getPrice() {
        Tax tax = new Tax();
        return tax.getPrice(imported, price * quontity, category);
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
