import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrinterTest {

    Printer printer;

    @Before
    public void setUp() throws Exception {
        printer = new Printer();
    }

    @Test
    public void printReceipt(){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        printer.printReceipt();
        assertEquals("Hello World", os.toString());
    }


}