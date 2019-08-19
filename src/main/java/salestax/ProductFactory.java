package salestax;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory {
    private List<Product> products = new ArrayList<>();
   public ProductFactory addProduct(String category, String name, double price, int quontity){
        Product product = new Product(category,name,price,quontity);
        products.add(product);
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }
}
