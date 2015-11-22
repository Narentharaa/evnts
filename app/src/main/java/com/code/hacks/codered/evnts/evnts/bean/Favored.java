package com.code.hacks.codered.evnts.evnts.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sudharti on 11/22/15.
 */
public class Favored {

    @SerializedName("favored")
    private boolean favored;

    public boolean isFavored() {
        return favored;
    }

    public void setFavored(boolean favored) {
        this.favored = favored;
    }
}
