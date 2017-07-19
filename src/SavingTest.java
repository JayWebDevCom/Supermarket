import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingTest {

    Saving saving;

    @Before
    public void setUp() throws Exception {
        saving = new Saving("Baked Beans", 1.99);
    }

    @Test
    public void savingName(){
        assertEquals("Baked Beans", saving.getName());
    }

    @Test
    public void savingPriceisNegatedOnInstantiation(){
        assertEquals(-1.99, saving.getPrice(), 0.001);
    }

}