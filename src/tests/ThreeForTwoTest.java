package tests;

import models.Basket;
import models.Product;
import models.Saving;
import models.offers.ThreeForTwo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ThreeForTwoTest {

    ThreeForTwo tft;
    Product juice;
    Basket basket;

    @Before
    public void setUp() throws Exception {
        juice = new Product("Juice", 1.99);
        tft = new ThreeForTwo("Three For Two", juice.getName());
        basket = new Basket(juice, juice, juice, juice, juice);
    }

    @Test
    public void addOffer(){
        assertEquals(1, tft.getIncludedProducts().size());
        Product yoghurt = new Product("Yoghurt", 1.49);
        tft.addProduct(yoghurt.getName());
        assertEquals(2, tft.getIncludedProducts().size());
    }

    @Test
    public void removeOffer(){
        assertEquals(1, tft.getIncludedProducts().size());
        tft.removeProduct(juice.getName());
        assertEquals(0, tft.getIncludedProducts().size());
    }

    @Test
    public void applyToBasketAddsOneSavingForThree() throws Exception {
        Basket basket = new Basket(juice, juice, juice);
        assertEquals(0, basket.getOffers().size());
        List<Saving> savings = tft.applyToBasket(basket.getItems());
        assertEquals(1, savings.size());
        assertEquals(-1 * juice.getPrice(), savings.get(0).getSaving(), 0.001);
    }

    @Test
    public void applyToBasketAddsOneSavingForFive() throws Exception {
        assertEquals(0, basket.getOffers().size());
        List<Saving> savings = tft.applyToBasket(basket.getItems());
        assertEquals(1, savings.size());
        assertEquals(-1 * juice.getPrice(), savings.get(0).getSaving(), 0.001);
    }

    @Test
    public void applyToBasketAddsTwoSavingForSix() throws Exception {
        assertEquals(0, basket.getOffers().size());
        basket.add(juice);
        List<Saving> savings = tft.applyToBasket(basket.getItems());
        assertEquals(2, savings.size());
        assertEquals(-1 * juice.getPrice(), savings.get(0).getSaving(), 0.001);
    }

    @Test
    public void applyToBasketNoSavingsWhenProductNotIncluded() throws Exception {
        assertEquals(0, basket.getOffers().size());
        tft.removeProduct(juice.getName());
        tft.applyToBasket(basket.getItems());
        assertEquals(0, basket.getOffers().size());
    }

}