package models;

import models.offers.Offer;
import models.offers.ThreeForTwo;
import models.offers.TwoForOne;
import models.offers.TwoForOnePound;

import java.util.*;

public class SavingsGenerator {

    private static List<Offer> offers;
    private Product coke = new Product("Coke", 0.70);
    private Product beans = new Product("Beans", 0.50);
    private Offer twoForOnePound = new TwoForOnePound("Two For £1", coke.getName());
    private Offer threeForTwo = new ThreeForTwo("Three For Two", beans.getName());
    private Offer  twoForOne = new TwoForOne("Two For One");

    public SavingsGenerator(Offer... variousOffers){
        offers = new ArrayList<>();
        Collections.addAll(offers, variousOffers);
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public List<Saving> generateSavingsFromOffers(List<Product> products) {
        List<Saving> savingsEarned = new ArrayList<>();
        for(Offer offer : getOffers()){
            savingsEarned.addAll(offer.generateSavings(products));
        }
        return savingsEarned;
    }

}
