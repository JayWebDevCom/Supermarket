import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SavingsGenerator {

    private ArrayList<Product> addedItems;

    public SavingsGenerator(){
        addedItems = new ArrayList<Product>();
    }

    public void identifySavings(Basket basket){

        for(Product item : basket.getItems()){

            int count = Collections.frequency(basket.getItems(), item);
            double numSaving = Math.floor(count/3);
            int numSavings = (int) numSaving;

            if ( !addedItems.contains(item) && item.getName() == "Coke" && numSavings > 0 ){

                for (int i = 0;  i < numSavings; i++) {
                    basket.addSaving(new Saving(item.getName(), item.getPrice()));
                }
            }
            addedItems.add(item);
        }

    }
}
