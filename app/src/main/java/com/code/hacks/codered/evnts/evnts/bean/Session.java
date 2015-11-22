package com.code.hacks.codered.evnts.evnts.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sudharti on 11/22/15.
 */
public class Session {
    @SerializedName("id")
    private String id;

    @SerializedName("email")
    private String email;

    @SerializedName("accessToken")
    private String accessToken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
