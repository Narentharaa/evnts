package com.code.hacks.codered.evnts.evnts.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sandeep on 11/22/2015.
 */
public class Universities {
    @SerializedName("universities")
    ArrayList<University> universities;

    public Universities(ArrayList<University> universities) {
        this.universities = universities;
    }

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public void setUniversities(ArrayList<University> universities) {
        this.universities = universities;
    }
}
