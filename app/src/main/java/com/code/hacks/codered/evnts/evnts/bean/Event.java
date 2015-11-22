package com.code.hacks.codered.evnts.evnts.bean;

/**
 * Created by sudharti on 11/21/15.
 */
public class Event {
    private String name, imageUrl;

    public Event(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
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
}
