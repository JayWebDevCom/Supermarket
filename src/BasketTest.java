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
        assertEquals(3, basket.getItems().size());
        basket.add(product);
        assertEquals(4, basket.getItems().size());
    }

    @Test
    public void addSaving(){
        Saving saving = new Saving("test product", 2.00, "test message");
        basket.addSaving(saving);
        assertTrue(basket.getSavingsItems().contains(saving));
    }

    @Test
    public void getSaving(){
        Saving saving = new Saving("test product", 2.00, "test message");
        basket.addSaving(saving);
        assertEquals(1, basket.getSavingsItems().size());
    }

}