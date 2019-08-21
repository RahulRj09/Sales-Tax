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

    public double getPrice() {
        this.price += this.taxAmount;
        return this.price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                quantity == product.quantity &&
                imported == product.imported;
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