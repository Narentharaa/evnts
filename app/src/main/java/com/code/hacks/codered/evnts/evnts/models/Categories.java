package com.code.hacks.codered.evnts.evnts.models;

import java.util.ArrayList;

/**
 * Created by sandeep on 11/22/2015.
 */
public class Categories {
ArrayList<Category> categories;

    public Categories(){

    }

    public Categories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
