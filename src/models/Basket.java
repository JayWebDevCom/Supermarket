package models;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> items;
    private ArrayList<Saving> offers;

    public Basket(Product... products){
        items = new ArrayList<Product>();
        offers = new ArrayList<Saving>();

        for (Product p : products) {
            items.add(p);
        }
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public void add(Product product) {
        items.add(product);
    }

    public void addOffer(Saving saving){
        offers.add(saving);
    }

    public ArrayList<Saving> getOffers(){
        return offers;
    }

}
