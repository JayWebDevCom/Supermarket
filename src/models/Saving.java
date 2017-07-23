package models;

public class Saving {

    private String name;

    private final String productName;
    private double saving;
    private String message;

    public String getName() {
        return name;
    }

    public String getProductName() {
        return productName;
    }

    public double getSaving() {
        return saving;
    }

    public String getMessage() {
        return message;
    }

    public Saving(String aproductName, double aPrice, String aMessage){
        productName = aproductName;
        name = "Two for one";
        saving = aPrice;
        message = aMessage;
        negatePrice();
    }

    private void negatePrice(){
        saving *= -1;
    }
}
