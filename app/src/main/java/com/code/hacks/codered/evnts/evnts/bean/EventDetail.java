package com.code.hacks.codered.evnts.evnts.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sandeep on 11/21/2015.
 */
public class EventDetail extends Event {
    @SerializedName("contact")
    private String contact;
    @SerializedName("prize")
    private String prize;
    @SerializedName("description")
    private String summary;
    @SerializedName("available")
    private int available;
    @SerializedName("filled")
    private int filled;
    @SerializedName("transport")
    private boolean transport;
    @SerializedName("food")
    private boolean food;
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("university_id")
    private int university_id;

    public EventDetail(String name, String imageUrl, String location, String date) {
        super(name, imageUrl, location, date);
    }

    public EventDetail(String name, String imageUrl, String location, String date, String contact, String prize, String summary, int available, int filled, boolean transport, boolean food, int categoryId, int university_id) {
        super(name, imageUrl, location, date);
        this.contact = contact;
        this.prize = prize;
        this.summary = summary;
        this.available = available;
        this.filled = filled;
        this.transport = transport;
        this.food = food;
        this.categoryId = categoryId;
        this.university_id = university_id;
    }

    public EventDetail(String name, String imageUrl, String location, String date, int id, String contact, String prize, String summary, int available, int filled, boolean transport, boolean food, int categoryId, int university_id) {
        super(name, imageUrl, location, date, id);
        this.contact = contact;
        this.prize = prize;
        this.summary = summary;
        this.available = available;
        this.filled = filled;
        this.transport = transport;
        this.food = food;
        this.categoryId = categoryId;
        this.university_id = university_id;
    }

    public EventDetail(String name, String imageUrl, String location, String date, String contact, String prize, String summary) {
        super(name, imageUrl, location, date);
        this.contact = contact;
        this.prize = prize;
        this.summary = summary;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }

    public boolean isTransport() {
        return transport;
    }

    public void setTransport(boolean transport) {
        this.transport = transport;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
