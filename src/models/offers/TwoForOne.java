package models.offers;

import models.Product;
import models.Saving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TwoForOne extends XForYOffer {

    public TwoForOne(String aName, String... products) {
        super(2, aName, products);
    }

}