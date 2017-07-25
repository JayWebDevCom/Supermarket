package tests;

import models.Basket;
import models.Product;
import models.Saving;
import models.offers.TwoForOnePound;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwoForOnePoundTest {

    private Product coke;
    private TwoForOnePound tfop;
    private Basket basket;

    @Before
    public void setUp() throws Exception {
        coke = new Product("Coke", 0.70);
        tfop = new TwoForOnePound("Two for £1", coke.getName());
        basket = new Basket(coke, coke, coke, coke);
    }

    @Test
    public void acceptsCoke(){
        assertEquals(1, tfop.getIncludedProducts().size());
    }

    @Test
    public void zeroSavingsForOneCoke(){
        basket = new Basket(coke);
        List<Saving> savings = tfop.generateSavings(basket.getProducts());
        assertEquals(0, savings.size());
    }

    @Test
    public void oneSavingForTwoCokes(){
        basket = new Basket(coke, coke);
        List<Saving> savings = tfop.generateSavings(basket.getProducts());
        assertEquals(1, savings.size());
    }

    @Test
    public void twoSavingsForThreeCokes(){
        List<Saving> savings = tfop.generateSavings(basket.getProducts());
        assertEquals(2, savings.size());
    }

    @Test
    public void twoSavingsForFourCokes(){
        basket.add(coke);
        List<Saving> savings = tfop.generateSavings(basket.getProducts());
        assertEquals(2,savings.size());
    }

    @Test
    public void offerProvidesSavingWithCorrectAmount(){
        List<Saving> savings = tfop.generateSavings(basket.getProducts());
        assertEquals(2, savings.size());
        assertEquals(-0.40, savings.get(0).getSaving(), 0.001);
        assertEquals(-0.40, savings.get(1).getSaving(), 0.001);
    }

    @Test
    public void offerProvidesSavingWithCorrectAmountTwo(){
        Product butter = new Product("Butter", 0.99);
        TwoForOnePound tfop = new TwoForOnePound("Two for £1", butter.getName());
        Basket basket = new Basket(butter, butter, butter);
        List<Saving> savings = tfop.generateSavings(basket.getProducts());
        assertEquals(1, savings.size());
        assertEquals(-0.98, savings.get(0).getSaving(), 0.001);
    }

    @Test
    public void applyToBasketNoSavingsWhenProductNotIncluded() throws Exception {
        tfop.removeProduct(coke.getName());
        List<Saving> savings = tfop.generateSavings(basket.getProducts());
        assertEquals(0, savings.size());
    }

}