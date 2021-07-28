package com.example.hotelreservationandroidapp.model;

public class HotelListData {

    private String id;
    private String hotel_name;
    private int price;
    private boolean availablity;

    public HotelListData(String id,String hotel_name, int price, boolean availability) {
        this.hotel_name = hotel_name;
        this.price = price;
        this.availablity = availability;
    }
    public HotelListData(String hotel_name, int price, boolean availability) {
        this.hotel_name = hotel_name;
        this.price = price;
        this.availablity = availability;
    }
    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getAvailability() {
        return availablity;
    }

    public void setAvailability(boolean availability) {
        this.availablity = availability;
    }
}
