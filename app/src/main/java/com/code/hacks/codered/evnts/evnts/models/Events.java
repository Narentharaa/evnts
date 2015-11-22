package com.code.hacks.codered.evnts.evnts.models;

import com.code.hacks.codered.evnts.evnts.bean.*;
import com.code.hacks.codered.evnts.evnts.bean.Event;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sande on 11/22/2015.
 */
public class Events {
    @SerializedName("events")
    ArrayList<com.code.hacks.codered.evnts.evnts.bean.Event> events;

    public Events() {
    }

    public Events(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
