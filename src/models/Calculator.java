package models;

import java.util.ArrayList;
import java.util.stream.DoubleStream;

public class Calculator {
    public double sum(ArrayList<Double> purchases, ArrayList<Double> savings) {
        return purchases.stream().reduce(0.0, Double::sum) + savings.stream().reduce(0.0, Double::sum);
    }
}
