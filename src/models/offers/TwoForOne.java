package models.offers;

import models.Basket;
import models.Product;
import models.Saving;

import java.util.ArrayList;
import java.util.Collections;

public class TwoForOne extends Offer {

    public TwoForOne(String aName) {
        super(aName);
    }

    @Override
    public void applyToBasket(Basket basket){

        ArrayList<Product> doneItems = new ArrayList<Product>();

        for (Product product : basket.getItems()) {

            if (!doneItems.contains(product) && includedProducts.contains(product)) {

            int countOfItemInBasket = Collections.frequency(basket.getItems(), product);
            double numSaving = Math.floor(countOfItemInBasket / 2);
            int numSavings = (int) numSaving;

                for (int i = 0; i < numSavings; i++) {
                    basket.addSaving(new Saving(product.getName(), 0.40, product.getName() + " 2 for $1"));
                }

        }

            doneItems.add(product);

        }




    }

}
