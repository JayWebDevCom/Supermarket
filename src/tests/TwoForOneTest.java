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
        assertEquals(0, basket.getOffers().size());
        twoForOne.applyToBasket(basket);
        assertEquals(2, basket.getOffers().size());
    }

    @Test
    public void applySavingsOnBeans2() throws Exception {
        assertEquals(0, basket.getOffers().size());
        basket.add(beans);
        twoForOne.applyToBasket(basket);
        assertEquals(3, basket.getOffers().size());
    }

    @Test
    public void applyToBasketNoSavingsWhenProductNotIncluded() throws Exception {
        assertEquals(0, basket.getOffers().size());
        twoForOne.removeProduct(beans);
        twoForOne.applyToBasket(basket);
        assertEquals(0, basket.getOffers().size());
    }

    @Test
    public void applyToBasketCokeAndBeansTogether() throws Exception {
        basket = new Basket(coke, coke, coke, coke, beans, beans, beans, beans);
        twoForOne.addProduct(coke);
        assertEquals(0, basket.getOffers().size());
        twoForOne.applyToBasket(basket);
        assertEquals(4, basket.getOffers().size());
    }

    @Test
    public void applyToBasketCokeAndBeansTogetherCorrectSavingAmout() throws Exception {
        basket = new Basket(coke, coke, coke, coke, beans, beans, beans, beans);
        twoForOne.addProduct(coke);
        assertEquals(0, basket.getOffers().size());
        twoForOne.applyToBasket(basket);
        assertEquals(4, basket.getOffers().size());
        assertEquals(-0.70, basket.getOffers().get(0).getSaving(), 0.01);
        assertEquals(-0.50, basket.getOffers().get(2).getSaving(), 0.01);
    }

}