package tests;

import models.Basket;
import models.Product;
import models.offers.ThreeForTwo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeForTwoTest {

    ThreeForTwo tft;
    Product juice;
    Basket basket;

    @Before
    public void setUp() throws Exception {
        juice = new Product("Juice", 1.99);
        tft = new ThreeForTwo("Three For Two", juice);
        basket = new Basket(juice, juice, juice, juice, juice);
    }

    @Test
    public void addOffer(){
        assertEquals(1, tft.getIncludedProducts().size());
        Product yoghurt = new Product("Yoghurt", 1.49);
        tft.addProduct(yoghurt);
        assertEquals(2, tft.getIncludedProducts().size());
    }

    @Test
    public void removeOffer(){
        assertEquals(1, tft.getIncludedProducts().size());
        tft.removeProduct(juice);
        assertEquals(0, tft.getIncludedProducts().size());
    }

    @Test
    public void applyToBasketAddsOneSavingForThree() throws Exception {
        Basket basket = new Basket(juice, juice, juice);
        assertEquals(0, basket.getOffers().size());
        tft.applyToBasket(basket);
        assertEquals(1, basket.getOffers().size());
        assertEquals(-1 * juice.getPrice(), basket.getOffers().get(0).getSaving(), 0.001);
    }

    @Test
    public void applyToBasketAddsOneSavingForFive() throws Exception {
        assertEquals(0, basket.getOffers().size());
        tft.applyToBasket(basket);
        assertEquals(1, basket.getOffers().size());
        assertEquals(-1 * juice.getPrice(), basket.getOffers().get(0).getSaving(), 0.001);
    }

    @Test
    public void applyToBasketAddsTwoSavingForSix() throws Exception {
        assertEquals(0, basket.getOffers().size());
        basket.add(juice);
        tft.applyToBasket(basket);
        assertEquals(2, basket.getOffers().size());
        assertEquals(-1 * juice.getPrice(), basket.getOffers().get(0).getSaving(), 0.001);
    }

    @Test
    public void applyToBasketNoSavingsWhenProductNotIncluded() throws Exception {
        assertEquals(0, basket.getOffers().size());
        tft.removeProduct(juice);
        tft.applyToBasket(basket);
        assertEquals(0, basket.getOffers().size());
    }

}