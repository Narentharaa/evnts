package com.code.hacks.codered.evnts.evnts.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by sandeep on 11/22/2015.
 */
public class Event {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("date")
    private Date date;

    @SerializedName("location")
    private String location;

    @SerializedName("status")
    private String status;

    @SerializedName("image")
    private String image;

    @SerializedName("category_id")
    private int categoryId;

    public Event(int id, String title, Date date, String location, String status, String image, int categoryId) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.location = location;
        this.status = status;
        this.image = image;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
