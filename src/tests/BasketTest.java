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
        Product peas = new Product("Peas", 0.99);
        Product rice = new Product("Rice", 3.99);
        basket.add(peas, rice);
        assertEquals(2, basket.getProducts().size());
    }

    @Test
    public void basketAddSubsequent(){
        Product product = new Product("Peas", 0.99);
        Basket basket = new Basket(product, product, product);
        basket.add(product);
        assertEquals(4, basket.getProducts().size());
    }

}