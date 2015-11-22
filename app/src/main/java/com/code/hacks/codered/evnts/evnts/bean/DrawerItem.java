package com.code.hacks.codered.evnts.evnts.bean;

/**
 * Created by sudharsanan on 4/13/15.
 */
public class DrawerItem {
    private String action;
    private int icon;
    private int id;

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
}
