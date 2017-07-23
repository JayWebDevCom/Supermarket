package models.offers;

import models.Basket;
import models.Product;
import models.Saving;

import java.util.ArrayList;
import java.util.Collections;

public class TwoForOnePound extends Offer {

    private static final int REQUIRED_NUMBER = 2;

    public TwoForOnePound(String aName, Product... products) {
        super(aName, products);
    }

    @Override
    public void applyToBasket(Basket basket){

        ArrayList<Product> doneItems = new ArrayList<Product>();

        for (Product product : basket.getItems()) {

            if (!doneItems.contains(product) && includedProducts.contains(product)) {

                int countOfItemInBasket = Collections.frequency(basket.getItems(), product);
                double numSaving = Math.floor(countOfItemInBasket / REQUIRED_NUMBER);
                int numSavings = (int) numSaving;
                double saving = (REQUIRED_NUMBER * product.getPrice()) - 1.00;

                for (int i = 0; i < numSavings; i++) {
                    basket.addSaving(new Saving(product.getName(), saving, product.getName() + ' ' + getName()));
                }

            }

            doneItems.add(product);

        }
    }
}
