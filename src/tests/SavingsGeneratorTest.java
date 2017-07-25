package tests;

import models.Basket;
import models.Product;
import models.Saving;
import models.SavingsGenerator;
import models.offers.Offer;
import models.offers.ThreeForTwo;
import models.offers.TwoForOne;
import models.offers.TwoForOnePound;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SavingsGeneratorTest {

    private Product coke; private Basket basket;
    private SavingsGenerator savGen;
    private Product beans;
    private Offer twoForOnePound;
    private Offer threeForTwo;
    private Offer  twoForOne;

    @Before
    public void setUp() throws Exception {
        coke = new Product("Coke", 0.70);
        beans = new Product("Beans", 0.50);
        basket = new Basket(beans, beans, beans, beans, coke, coke, coke);
        twoForOnePound = new TwoForOnePound("Two For £1", coke.getName());
        threeForTwo = new ThreeForTwo("Three For Two", beans.getName());
        twoForOne = new TwoForOne("Two For One");
        savGen = new SavingsGenerator(threeForTwo, twoForOne, twoForOnePound);
    }

    @Test
    public void threeOffersByDefault(){
        assertEquals(3, savGen.getOffers().size());
    }

    @Test
    public void appliesThreeForTwoCorrectly(){
        /*
        * 2 Savings should be added - 1 for 3for2 beans and 1 for 2for1 coke
        */
        List<Saving> savings = savGen.generateSavingsFromOffers(basket.getProducts());
        assertEquals(2, savings.size());
    }

    @Test
    public void appliesThreeForTwoCorrectlyWithMore(){
        /*
        * 4 Savings should be added - 2 for 3for2 beans and 2 for 2for1 coke
        */
        basket.add(coke, beans, beans);
        List<Saving> savings = savGen.generateSavingsFromOffers(basket.getProducts());
        assertEquals(4, savings.size());
    }

}