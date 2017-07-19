public class Saving {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Saving(String aName, double aPrice){
        name = aName;
        price = aPrice;
        negatePrice();
    }

    public void negatePrice(){
        price *= -1;
    }

}
