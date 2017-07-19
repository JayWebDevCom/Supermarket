import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    Product product;

    @Before
    public void setUp(){
        product = new Product("Baked Beans", 1.99);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Baked Beans", product.getName());
    }

    @Test
    public void getPrice() throws Exception {
        assertEquals(1.99, product.getPrice(), 0.001);
    }

}