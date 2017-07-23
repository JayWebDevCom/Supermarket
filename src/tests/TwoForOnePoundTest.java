package tests;

import models.Basket;
import models.Product;
import models.offers.TwoForOnePound;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoForOnePoundTest {

    private Product coke;
    private TwoForOnePound tfop;
    Basket basket;

    @Before
    public void setUp() throws Exception {
        coke = new Product("Coke", 0.70);
        tfop = new TwoForOnePound("Two for £1", coke);
        basket = new Basket(coke, coke, coke, coke);
    }

    @Test
    public void acceptsCoke(){
        assertEquals(1, tfop.getIncludedProducts().size());
    }

    @Test
    public void zeroSavingsForOneCoke(){
        basket = new Basket(coke);
        tfop.applyToBasket(basket);
        assertEquals(0, basket.getSavingsItems().size());
    }

    @Test
    public void oneSavingForTwoCokes(){
        basket = new Basket(coke, coke);
        tfop.applyToBasket(basket);
        assertEquals(1, basket.getSavingsItems().size());
    }

    @Test
    public void twoSavingsForThreeCokes(){
        tfop.applyToBasket(basket);
        assertEquals(2, basket.getSavingsItems().size());
    }

    @Test
    public void twoSavingsForFourCokes(){
        basket.add(coke);
        tfop.applyToBasket(basket);
        assertEquals(2, basket.getSavingsItems().size());
    }

}