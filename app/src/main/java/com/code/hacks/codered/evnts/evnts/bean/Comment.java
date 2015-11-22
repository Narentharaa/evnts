package com.code.hacks.codered.evnts.evnts.bean;

/**
 * Created by sandeep on 11/22/2015.
 */
public class Comment {

    private String userName;
    private String comment;
    private String date;

    public Comment(String userName, String comment, String date) {
        this.userName = userName;
        this.comment = comment;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
