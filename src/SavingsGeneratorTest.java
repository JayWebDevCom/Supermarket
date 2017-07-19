import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsGeneratorTest {

    Product coke; Basket basket; SavingsGenerator savGen;

    @Before
    public void setUp() throws Exception {
        coke = new Product("Coke", 1.00);
        basket = new Basket(coke, coke, coke, coke, coke);
        savGen = new SavingsGenerator();
    }

    @Test
    public void identifySavingsAddsAsASavingsObject() throws Exception {
        savGen.identifySavings(basket);
        assertEquals(1, basket.getSavingsItems().size());
    }

    @Test
    public void identifySavingsAddsAsMultipleSavingsObject() throws Exception {
        basket = new Basket(coke, coke, coke, coke, coke, coke);
        savGen.identifySavings(basket);
        assertEquals(2, basket.getSavingsItems().size());
    }

    @Test
    public void identifySavingsAddsAsMultipleSavingsObjectTwo() throws Exception {
        basket = new Basket(coke, coke, coke, coke, coke, coke, coke, coke, coke);
        savGen.identifySavings(basket);
        assertEquals(3, basket.getSavingsItems().size());
    }

    @Test
    public void identifySavingsAddsAsMultipleSavingsObjectThree() throws Exception {
        basket = new Basket(coke, coke, coke, coke, coke, coke, coke, coke, coke, coke);
        savGen.identifySavings(basket);
        assertEquals(3, basket.getSavingsItems().size());
    }

}