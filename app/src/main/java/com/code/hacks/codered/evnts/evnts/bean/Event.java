package com.code.hacks.codered.evnts.evnts.bean;

/**
 * Created by sudharti on 11/21/15.
 */
public class Event {
    private String name, imageUrl, location, date;

    public Event(String name, String imageUrl, String location, String date) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
