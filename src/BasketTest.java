import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {

    Basket basket;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
    }

    @Test
    public void basketAdd(){
        Product product = new Product("Peas", 0.99);
        basket.add(product);
        assertEquals(1, basket.getItems().size());
    }

    @Test
    public void basketAddSubsequent(){
        Product product = new Product("Peas", 0.99);
        Basket basket = new Basket(product, product, product);
        basket.add(product);
        assertEquals(4, basket.getItems().size());
    }

}