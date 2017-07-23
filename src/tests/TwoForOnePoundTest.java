package tests;

import models.Product;
import models.offers.TwoForOnePound;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoForOnePoundTest {

    private Product coke;
    private TwoForOnePound tfop;

    @Before
    public void setUp() throws Exception {
        coke = new Product("Coke", 0.70);
        tfop = new TwoForOnePound("Two for £1", coke);
    }

    @Test
    public void acceptsCoke(){
        assertEquals(1, tfop.getIncludedProducts().size());
    }

}