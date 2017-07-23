package models.offers;

import models.Basket;
import models.Product;

import java.util.ArrayList;

public abstract class Offer {

    private String name;
    public ArrayList<Product> includedProducts;

    public Offer(String aName, Product... products){
        name = aName;
        includedProducts = new ArrayList<Product>();
        for (Product product : products) {
            addProduct(product);
        }
    }

    public void addProduct(Product product){
        includedProducts.add(product);
    }

    public void removeProduct(Product product){
        includedProducts.remove(product);
    }

    public ArrayList<Product> getIncludedProducts(){
        return includedProducts;
    }

    public String getName() {
        return name;
    }

    public abstract void applyToBasket(Basket basket);

}
