package models;

public class Saving {

    private String productName;
    private double price;
    private String message;

    public String getName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    public Saving(String aName, double aPrice, String aMessage){
        productName = aName;
        price = aPrice;
        message = aMessage;
        negatePrice();
    }

    private void negatePrice(){
        price *= -1;
    }
}
