package models.offers;

import models.Basket;
import models.Product;

public class TwoForOnePound extends Offer {

    public TwoForOnePound(String aName, Product... products) {
        super(aName, products);
    }

    @Override
    public void applyToBasket(Basket basket){

    }
}
