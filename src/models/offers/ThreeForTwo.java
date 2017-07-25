package models.offers;

import models.Basket;
import models.Product;
import models.Saving;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeForTwo extends Offer {

    private static final int REQUIRED_NUMBER = 3;

    public ThreeForTwo(String aName, Product... products) {
        super(aName, products);
    }

    @Override
    public void applyToBasket(Basket basket){

        ArrayList<Product> doneItems = new ArrayList<Product>();

        System.out.println("1");

        for (Product product : basket.getItems()) {

            if (!doneItems.contains(product) && includedProducts.contains(product)) {

                int countOfItemInBasket = Collections.frequency(basket.getItems(), product);
                double numSaving = Math.floor(countOfItemInBasket / REQUIRED_NUMBER);
                int numSavings = (int) numSaving;

                for (int i = 0; i < numSavings; i++) {
                    basket.addOffer(new Saving(product.getName(), product.getPrice(), product.getName() + ' ' + getName()));
                }

            }

            doneItems.add(product);

        }
    }
}