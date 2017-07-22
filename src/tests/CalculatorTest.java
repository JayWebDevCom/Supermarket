package tests;

import models.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CalculatorTest {

    ArrayList<Double> purchases;
    ArrayList<Double> savings;
    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        purchases = new ArrayList<>(Arrays.asList(2.25, 2.50, 2.75));
        savings = new ArrayList<>(Arrays.asList(-2.00));
        calculator = new Calculator();
    }

    @Test
    public void addSumsTwoListsOfDoubles() {
        assertEquals(5.50, calculator.sum(purchases, savings), 0.0);
    }


}