package models;

import java.util.*;

public class SavingsGenerator {

    private ArrayList<Product> addedItems;
    private static Hashtable<String, String> productClasses;

    public SavingsGenerator(){
        addedItems = new ArrayList<Product>();
        productClasses = new Hashtable<String, String>(){{
            put("models.Coke", "models.Coke");
        }};
    }

    public void identifySavings(Basket basket){

        for(Product item : basket.getItems()){

//            Class<?> c = Class.forName(item.getName());
//            Constructor<?> cons = c.getConstructor();
//            Object specProduct = cons.newInstance(item.getName(), item.getPrice());

            int count;
            double numSaving;
            int numSavings;


            if ( !addedItems.contains(item) && item.getName() == "models.Coke" ) {
                count = Collections.frequency(basket.getItems(), item);
                numSaving = Math.floor(count/2);
                numSavings = (int) numSaving;
                for (int i = 0;  i < numSavings; i++) {
                    basket.addSaving(new Saving(item.getName(), 0.40, item.getName() + " 2 for $1"));
                }

            }

            if ( !addedItems.contains(item) && item.getName() == "Beans" ) {
                count = Collections.frequency(basket.getItems(), item);
                numSaving = Math.floor(count/3);
                numSavings = (int) numSaving;

                for (int i = 0;  i < numSavings; i++) {
                    basket.addSaving(new Saving(item.getName(), 0.40, item.getName() + " 2 for $1"));
                }

            }

            addedItems.add(item);
        }

    }
}
