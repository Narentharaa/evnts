package com.code.hacks.codered.evnts.evnts.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sudharti on 11/21/15.
 */
public class Event {
    @SerializedName("title")
    String name;
    @SerializedName("image")
    String imageUrl;
    @SerializedName("location")
    String location;
    @SerializedName("when")
    String date;
    @SerializedName("id")
    int id;

    public Event(String name, String imageUrl, String location, String date) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
        this.date = date;
        this.imageUrl=imageUrl;
    }

    public Event(String name, String imageUrl, String location, String date, int id) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
        this.date = date;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                '}';
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
