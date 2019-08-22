package salestax;

import java.util.Map;

public class CostCalculator {
    private double totalTaxAmount = 0;
    private double totalAllProductCostAmount = 0;
    public Map<Product, Integer> costCalculate(Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            product.getKey().price = getPrice(product);
        }
        return products;
    }

    private double getPrice(Map.Entry<Product, Integer> product) {
        return product.getKey().price * product.getValue();
    }

    public Map<Product, Double> costCalculateWithTax(Map<Product, Double> products) {
        for (Map.Entry<Product, Double> product : products.entrySet()) {
            product.getKey().price += product.getValue();
            this.totalTaxAmount +=product.getValue();
            this.totalAllProductCostAmount +=product.getKey().price;
        }
        return products;
    }

    public double getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public double getTotalAllProductCostAmount() {
        return totalAllProductCostAmount;
    }
}
