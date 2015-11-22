package com.code.hacks.codered.evnts.evnts.bean;

/**
 * Created by sandeep on 11/21/2015.
 */
public class EventDetail extends Event {

    private String contact, prize, summary;

    public EventDetail(String name, String imageUrl, String location, String date) {
        super(name, imageUrl, location, date);
    }

    public EventDetail(String name, String imageUrl, String location, String date, String contact, String prize, String summary) {
        super(name, imageUrl, location, date);
        this.contact = contact;
        this.prize = prize;
        this.summary = summary;
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
