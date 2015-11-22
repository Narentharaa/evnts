package com.code.hacks.codered.evnts.evnts.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sandeep on 11/22/2015.
 */
public class Category {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
