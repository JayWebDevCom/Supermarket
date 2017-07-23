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
    public void applyToBasketAddsCorrecNumberOfSavings() throws Exception {
        tft.applyToBasket(basket);
        assertEquals(1, basket.getSavingsItems().size());
        assertEquals(-1 * juice.getPrice(), basket.getSavingsItems().get(0).getSaving(), 0.001);
    }

}