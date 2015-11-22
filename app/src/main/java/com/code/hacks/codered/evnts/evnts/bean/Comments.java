package com.code.hacks.codered.evnts.evnts.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sandeep on 11/22/2015.
 */
public class Comments {
    @SerializedName("comments")
    ArrayList<Comment> comments;

    public Comments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
