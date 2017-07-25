package tests;

import models.Basket;
import models.Product;
import models.Saving;
import models.offers.TwoForOne;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
        twoForOne = new TwoForOne("Two For One", beans.getName());
    }

    @Test
    public void add() throws Exception {
        assertEquals(1, twoForOne.getIncludedProducts().size());
    }

    @Test
    public void applySavingsOnBeans() throws Exception {
        List<Saving> savings = twoForOne.applyToBasket(basket.getProducts());
        assertEquals(2, savings.size());
    }

    @Test
    public void applySavingsOnBeans2() throws Exception {
        basket.add(beans);
        List<Saving> savings = twoForOne.applyToBasket(basket.getProducts());
        assertEquals(3, savings.size());
    }

    @Test
    public void applyToBasketNoSavingsWhenProductNotIncluded() throws Exception {
        twoForOne.removeProduct(beans.getName());
        List<Saving> savings = twoForOne.applyToBasket(basket.getProducts());
        assertEquals(0, savings.size());
    }

    @Test
    public void applyToBasketCokeAndBeansTogether() throws Exception {
        basket = new Basket(coke, coke, coke, coke, beans, beans, beans, beans, beans, coke);
        twoForOne.addProduct(coke.getName());
        List<Saving> savings = twoForOne.applyToBasket(basket.getProducts());
        assertEquals(4, savings.size());
    }

    @Test
    public void applyToBasketCokeAndBeansTogetherCorrectSavingAmount() throws Exception {
        basket = new Basket(coke, coke, coke, coke, beans, beans, beans, beans, beans, coke);
        twoForOne.addProduct(coke.getName());
        List<Saving> savings = twoForOne.applyToBasket(basket.getProducts());
        assertEquals(4, savings.size());
        assertEquals(-0.70, savings.get(0).getSaving(), 0.01);
        assertEquals(-0.50, savings.get(2).getSaving(), 0.01);
    }

}