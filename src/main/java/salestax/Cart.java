package salestax;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product,Integer> items = new HashMap<>();
   Map<Product,Integer> add(Product product,int quantity){
       this.items.put(product,quantity);
       return items;
   }
}
