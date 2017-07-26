package models.offers;

import models.Product;
import models.Saving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class XForYOffer extends Offer {

    private final int requiredNumber;

    XForYOffer(int requiredNumber, String name, String... products) {
        super(name, products);
        this.requiredNumber = requiredNumber;
    }

    @Override
    public List<Saving> generateSavings(List<Product> items){

        List<Product> doneItems = new ArrayList<>();
        List<Saving> savings = new ArrayList<>();

        for (Product product : items) {

            if (!doneItems.contains(product) && getIncludedProducts().contains(product.getName())) {

                int countOfItemInBasket = Collections.frequency(items, product);
                double numSaving = Math.floor(countOfItemInBasket / requiredNumber);
                int numSavings = (int) numSaving;

                for (int i = 0; i < numSavings; i++) {
                    savings.add(new Saving(product.getName(), product.getPrice(), product.getName() + ' ' + getName()));
                }

            }
                doneItems.add(product);
        }

        return savings;
    }
}
