package tests;

import models.Basket;
import models.Product;
import models.SavingsGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsGeneratorTest {

    Product coke; Basket basket; SavingsGenerator savGen; Product beans;

    @Before
    public void setUp() throws Exception {
        coke = new Product("Coke", 0.70);
        beans = new Product("Beans", 0.50);
        basket = new Basket(coke, coke, coke, coke, coke, beans, beans, beans);
        savGen = new SavingsGenerator();
    }

    @Test
    public void identifySavingsAddsAsASavingsObjectBeansAndCoke() throws Exception {
        savGen.identifySavings(basket);
        assertEquals(3, basket.getSavingsItems().size());
    }

    @Test
    public void identifySavingsAddsAsMultipleSavingsObjectCoke() throws Exception {
        basket = new Basket(coke, coke, coke, coke, coke, coke);
        savGen.identifySavings(basket);
        assertEquals(3, basket.getSavingsItems().size());
    }

    @Test
    public void identifySavingsAddsAsMultipleSavingsObjectBeans() throws Exception {
        basket = new Basket(beans, beans, beans);
        savGen.identifySavings(basket);
        assertEquals(1, basket.getSavingsItems().size());
    }

    @Test
    public void identifySavingsAddsAsMultipleSavingsObjectBeansTwo() throws Exception {
        basket = new Basket(beans, beans, beans, beans);
        savGen.identifySavings(basket);
        assertEquals(1, basket.getSavingsItems().size());
    }

    @Test
    public void identifySavingsAddsAsMultipleSavingsObjectBeansThree() throws Exception {
        basket = new Basket(beans, beans, beans, beans, beans);
        savGen.identifySavings(basket);
        assertEquals(1, basket.getSavingsItems().size());
    }

    @Test
    public void identifySavingsAddsAsMultipleSavingsCokeObjectTwo() throws Exception {
        basket = new Basket(coke, coke, coke, coke, coke, coke, coke, coke, coke);
        savGen.identifySavings(basket);
        assertEquals(4, basket.getSavingsItems().size());
    }

    @Test
    public void identifySavingsAddsAsMultipleSavingsObjectThree() throws Exception {
        basket = new Basket(coke, coke, coke, coke, coke, coke, coke, coke, coke, coke);
        savGen.identifySavings(basket);
        assertEquals(5, basket.getSavingsItems().size());
    }

}