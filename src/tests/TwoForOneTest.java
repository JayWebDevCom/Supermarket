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
        basket = new Basket(coke, coke, coke, beans, beans, beans, beans, beans);
        twoForOne = new TwoForOne("Two For One", beans);
    }

    @Test
    public void add() throws Exception {
        assertEquals(1, twoForOne.getIncludedProducts().size());
    }

    @Test
    public void applySavingsOnBeans() throws Exception {
        assertEquals(0, basket.getSavingsItems().size());
        twoForOne.applyToBasket(basket);
        assertEquals(2, basket.getSavingsItems().size());
    }

    @Test
    public void applySavingsOnBeans2() throws Exception {
        assertEquals(0, basket.getSavingsItems().size());
        basket.add(beans);
        twoForOne.applyToBasket(basket);
        assertEquals(3, basket.getSavingsItems().size());
    }

    @Test
    public void applyToBasketNoSavingsWhenProductNotIncluded() throws Exception {
        assertEquals(0, basket.getSavingsItems().size());
        twoForOne.remove(beans);
        twoForOne.applyToBasket(basket);
        assertEquals(0, basket.getSavingsItems().size());
    }

    @Test
    public void applyToBasketCokeAndBeansTogether() throws Exception {
        basket = new Basket(coke, coke, coke, coke, beans, beans, beans, beans);
        twoForOne.add(coke);
        assertEquals(0, basket.getSavingsItems().size());
        twoForOne.applyToBasket(basket);
        assertEquals(4, basket.getSavingsItems().size());
    }

    @Test
    public void applyToBasketCokeAndBeansTogetherCorrectSavingAmout() throws Exception {
        basket = new Basket(coke, coke, coke, coke, beans, beans, beans, beans);
        twoForOne.add(coke);
        assertEquals(0, basket.getSavingsItems().size());
        twoForOne.applyToBasket(basket);
        assertEquals(4, basket.getSavingsItems().size());
        assertEquals(-0.70, basket.getSavingsItems().get(0).getSaving(), 0.01);
        assertEquals(-0.50, basket.getSavingsItems().get(2).getSaving(), 0.01);
    }

}