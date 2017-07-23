package models;

import models.offers.Offer;
import models.offers.ThreeForTwo;
import models.offers.TwoForOne;
import models.offers.TwoForOnePound;

import java.util.*;

public class SavingsGenerator {

    private static ArrayList<Offer> offers;
    private Product coke = new Product("Coke", 0.70);
    private Product beans = new Product("Beans", 0.50);
    private Offer twoForOne, threeForTwo, twoForOnePound;

    public SavingsGenerator(){
        offers = new ArrayList<Offer>(
                (Arrays.asList(
                        twoForOnePound = new TwoForOnePound("Two For £1", coke),
                        threeForTwo = new ThreeForTwo("Three For Two", beans),
                        twoForOne = new TwoForOne("Two For One")
                )
                )
        );

    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }


    public void applyOffers(Basket basket) {
        for(Offer offer : getOffers()){
            offer.applyToBasket(basket);
        }
    }

}
