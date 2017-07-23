package tests;

import models.Basket;
import models.Product;
import models.offers.TwoForOne;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoForOneTest {

    private TwoForOne twoForOne;
    private Product coke, beans;
    private Basket basket;

    @Before
    public void setUp() throws Exception {
        coke = new Product("Coke", 0.70);
        beans = new Product("Beans", 0.50);
        basket = new Basket(coke, coke, coke, coke, coke, beans, beans, beans);
        twoForOne = new TwoForOne("Two For One", coke);
    }

    @Test
    public void add() throws Exception {
        assertEquals(1, twoForOne.getIncludedProducts().size());
    }

    @Test
    public void ApplySavingsCokeOnly() throws Exception {
        assertEquals(0, basket.getSavingsItems().size());
        twoForOne.applyToBasket(basket);
        assertEquals(2, basket.getSavingsItems().size());
    }

    @Test
    public void ApplySavingsCokeOnly2() throws Exception {
        assertEquals(0, basket.getSavingsItems().size());
        basket.add(coke);
        twoForOne.applyToBasket(basket);
        assertEquals(3, basket.getSavingsItems().size());
    }

    @Test
    public void ApplySavingsCokeOnly3() throws Exception {
        assertEquals(0, basket.getSavingsItems().size());
        basket.add(coke);
        twoForOne.applyToBasket(basket);
        assertEquals(3, basket.getSavingsItems().size());
    }


}