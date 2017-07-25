package models;

import java.util.ArrayList;
import java.util.Collections;

public class Basket {

    private ArrayList<Product> products;

    public Basket(Product... products){
        this.products = new ArrayList<>();
        Collections.addAll(this.products, products);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void add(Product... products) {
        Collections.addAll(this.products, products);
    }

}
