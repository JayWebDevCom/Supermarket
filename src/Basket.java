import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> items;

    public Basket(Product... products){
        items = new ArrayList<Product>();
        for (Product p : products) {
            items.add(p);
        }
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public void add(Product product) {
        items.add(product);
    }

}
