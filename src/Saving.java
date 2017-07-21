public class Saving {

    private String name;
    private double price;
    private String message;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    public Saving(String aName, double aPrice, String aMessage){
        name = aName;
        price = aPrice;
        message = aMessage;
        negatePrice();
    }

    public void negatePrice(){
        price *= -1;
    }


}
