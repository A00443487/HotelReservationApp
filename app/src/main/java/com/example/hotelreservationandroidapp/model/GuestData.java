package com.example.hotelreservationandroidapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GuestData {

    @SerializedName("checkin")
    private String checkin;
    @SerializedName("checkout")
    private String checkout;
    @SerializedName("hotel_name")
    private String hotel_name;
    @SerializedName("guest_list")
private List<Guest> guest_list;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public List<Guest> getGuest_list() {
        return guest_list;
    }

    public void setGuest_list(List<Guest> guest_list) {
        this.guest_list = guest_list;
    }
}
