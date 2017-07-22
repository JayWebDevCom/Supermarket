package models;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> items;
    private ArrayList<Saving> savingItems;

    public Basket(Product... products){
        items = new ArrayList<Product>();
        savingItems = new ArrayList<Saving>();

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

    public void addSaving(Saving saving){
        savingItems.add(saving);
    }

    public ArrayList<Saving> getSavingsItems(){
        return savingItems;
    }

}
