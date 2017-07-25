package tests;

import models.Basket;
import models.Product;
import models.Saving;
import models.SavingsGenerator;
import models.offers.Offer;
import models.offers.ThreeForTwo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SavingsGeneratorTest {

    Product coke; Basket basket; SavingsGenerator savGen; Product beans;

    @Before
    public void setUp() throws Exception {
        coke = new Product("Coke", 0.70);
        beans = new Product("Beans", 0.50);
        basket = new Basket(beans, beans, beans);
        savGen = new SavingsGenerator();
    }

    @Test
    public void threeOffersByDefault(){
        assertEquals(3, savGen.getOffers().size());
    }

    @Test
    public void appliesThreeForTwoCorrectly(){
        assertEquals(0, basket.getOffers().size());
        List<Saving> savings = savGen.applyOffers(basket.getItems());
        assertEquals(1, savings.size());
    }

}