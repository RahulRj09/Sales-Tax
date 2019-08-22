package salestax;

import java.util.Map;

public class CostCalculator {
    public Map<Product,Integer> costCalculate(Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product,Integer> product: products.entrySet()) {
            product.getKey().price = getPrice(product);
        }
        return products;
    }

    private double getPrice(Map.Entry<Product, Integer> product) {
       return product.getKey().price* product.getValue();
    }

    public Map<Product,Integer> costCalculateWithTax(Map<Product, Double> products){
        return null;
    }
}
