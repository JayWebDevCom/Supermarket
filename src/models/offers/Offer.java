package models.offers;

import models.Basket;
import models.Product;
import models.Saving;

import java.util.ArrayList;
import java.util.List;

public abstract class Offer {

    private String name;
    public List<String> includedProducts;

    public Offer(String aName, String... products){
        name = aName;
        includedProducts = new ArrayList<String>();
        for (String product : products) {
            addProduct(product);
        }
    }

    public void addProduct(String product){
        includedProducts.add(product);
    }

    public void removeProduct(String product){
        includedProducts.remove(product);
    }

    public List<String> getIncludedProducts(){
        return includedProducts;
    }

    public String getName() {
        return name;
    }

    public abstract List<Saving> applyToBasket(List<Product> items);

}
