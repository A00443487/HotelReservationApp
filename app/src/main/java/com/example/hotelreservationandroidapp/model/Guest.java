package com.example.hotelreservationandroidapp.model;

import com.google.gson.annotations.SerializedName;

public class Guest {

    @SerializedName("guest_name")
    private String guest_name;
    @SerializedName("gender")
    private  String gender;

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
