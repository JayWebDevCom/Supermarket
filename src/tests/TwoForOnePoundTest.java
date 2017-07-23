package tests;

import models.Basket;
import models.Product;
import models.offers.TwoForOne;
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

    @Test
    public void offerProvidesSavingWithCorrectAmount(){
        tfop.applyToBasket(basket);
        assertEquals(2, basket.getSavingsItems().size());
        assertEquals(-0.40, basket.getSavingsItems().get(0).getSaving(), 0.001);
        assertEquals(-0.40, basket.getSavingsItems().get(1).getSaving(), 0.001);
    }

    @Test
    public void offerProvidesSavingWithCorrectAmountTwo(){
        Product butter = new Product("Butter", 0.99);
        TwoForOnePound tfop = new TwoForOnePound("Two for £1", butter);
        Basket basket = new Basket(butter, butter, butter);
        tfop.applyToBasket(basket);
        assertEquals(1, basket.getSavingsItems().size());
        assertEquals(-0.98, basket.getSavingsItems().get(0).getSaving(), 0.001);
    }

    @Test
    public void applyToBasketNoSavingsWhenProductNotIncluded() throws Exception {
        assertEquals(0, basket.getSavingsItems().size());
        tfop.remove(coke);
        tfop.applyToBasket(basket);
        assertEquals(0, basket.getSavingsItems().size());
    }

}