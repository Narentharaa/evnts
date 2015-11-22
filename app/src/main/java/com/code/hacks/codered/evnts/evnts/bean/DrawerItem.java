package com.code.hacks.codered.evnts.evnts.bean;

/**
 * Created by sudharsanan on 4/13/15.
 */
public class DrawerItem {
    private String action;
    private int icon;
    private int id;
    private String userName;
    private String comment;
    private String date;

    public DrawerItem(String userName, String comment, String date) {
        this.userName = userName;
        this.comment = comment;
        this.date = date;
    }

    public DrawerItem(String action, int icon) {
        this.action = action;
        this.icon = icon;
    }

    public DrawerItem(String action, int icon, int id) {
        this.action = action;
        this.icon = icon;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
}
