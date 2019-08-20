package salestax;

import java.util.Objects;

public class Product {
    private String category;
    private String name;
    private double price;
    private int quantity;
    private boolean imported;
    private boolean taxable;

    public Product(String category, String name, double price, int quantity, boolean imported, boolean taxable) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imported = imported;
        this.taxable = taxable;
    }
    public double getTaxAmount() {
        Tax tax = new Tax();
        double taxAmount = tax.getTax(imported, price * quantity, taxable);
        this.price += taxAmount;
        return taxAmount;
    }

    public double getPrice() {
        return this.price;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                quantity == product.quantity &&
                imported == product.imported &&
                Objects.equals(category, product.category) &&
                Objects.equals(name, product.name);
    }

    @Override
    public String toString() {
        return "Product { " +
                " category = " + category +
                " , name = " + name +
                " , price = " + this.price +
                " , quantity = " + quantity +
                " }";
    }
}