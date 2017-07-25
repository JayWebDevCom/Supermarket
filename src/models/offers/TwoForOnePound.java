package models.offers;

import models.Product;
import models.Saving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoForOnePound extends Offer {

    private static final int REQUIRED_NUMBER = 2;

    public TwoForOnePound(String aName, String... products) {
        super(aName, products);
    }

    @Override
    public List<Saving> generateSavings(List<Product> items){

        List<Product> doneItems = new ArrayList<>();
        List<Saving> savings = new ArrayList<>();

        for (Product product : items) {

            if (!doneItems.contains(product) && getIncludedProducts().contains(product.getName())) {

                int countOfItemInBasket = Collections.frequency(items, product);
                double numSaving = Math.floor(countOfItemInBasket / REQUIRED_NUMBER);
                int numSavings = (int) numSaving;
                double saving = (REQUIRED_NUMBER * product.getPrice()) - 1.00;

                for (int i = 0; i < numSavings; i++) {
                    savings.add(new Saving(product.getName(), saving, product.getName() + ' ' + getName()));
                }

            }

            doneItems.add(product);

        }
        return savings;
    }
}
