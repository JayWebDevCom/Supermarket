package models;

public class Product {

    private String name;
    private double price;

    public Product(String aName, double aPrice){
        name = aName;
        price = aPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
