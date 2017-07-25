package tests;

import models.Basket;
import models.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
    }

    @Test
    public void basketAdd(){
        Product product = new Product("Peas", 0.99);
        basket.add(product);
        assertEquals(1, basket.getProducts().size());
    }

    @Test
    public void basketAddSubsequent(){
        Product product = new Product("Peas", 0.99);
        Basket basket = new Basket(product, product, product);
        assertEquals(3, basket.getProducts().size());
        basket.add(product);
        assertEquals(4, basket.getProducts().size());
    }

}