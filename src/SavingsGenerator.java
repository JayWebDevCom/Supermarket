import javax.swing.*;
import java.lang.reflect.Constructor;
import java.util.*;

public class SavingsGenerator {

    private ArrayList<Product> addedItems;
    private static Hashtable<String, String> productClasses;

    public SavingsGenerator(){
        addedItems = new ArrayList<Product>();
        productClasses = new Hashtable<String, String>(){{
            put("Coke", "Coke");
        }};
    }

    public void identifySavings(Basket basket){

        for(Product item : basket.getItems()){

//            Class<?> c = Class.forName(item.getName());
//            Constructor<?> cons = c.getConstructor();
//            Object specProduct = cons.newInstance(item.getName(), item.getPrice());

            int count = Collections.frequency(basket.getItems(), item);
            double numSaving = Math.floor(count/2);
            int numSavings = (int) numSaving;

            if ( !addedItems.contains(item) && item.getName() == "Coke" && numSavings > 0 ){

                for (int i = 0;  i < numSavings; i++) {
                    basket.addSaving(new Saving(item.getName(), 0.40, item.getName() + " 2 for $1"));
                }
            }

            addedItems.add(item);

        }

    }
}
