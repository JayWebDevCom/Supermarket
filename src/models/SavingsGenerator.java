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
        offers = new ArrayList<>(
                (Arrays.asList(
                        twoForOnePound = new TwoForOnePound("Two For £1", coke.getName()),
                        threeForTwo = new ThreeForTwo("Three For Two", beans.getName()),
                        twoForOne = new TwoForOne("Two For One")
                )
                )
        );

    }

    public ArrayList<Offer> getOffers() {
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
