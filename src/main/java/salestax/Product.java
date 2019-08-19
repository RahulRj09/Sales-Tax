package salestax;

public class Product {
    public String category;
    public String name;
    public double price;
    public int quontity;

    public Product(String category,String name, double price, int quontity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quontity = quontity;
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
                ",quontity="+ quontity+
                '}';
    }
}
