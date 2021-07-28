package com.example.hotelreservationandroidapp.network.service;





import com.example.hotelreservationandroidapp.model.GuestData;
import com.example.hotelreservationandroidapp.model.HotelListData;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;

import retrofit.http.Headers;

import retrofit.http.POST;


public interface ApiInterface {

    // API's endpoints
    @GET("/hotel-list")
    public void getHotelsLists(Callback<List<HotelListData>> callback);



    @POST("/hotel-reservation")
    public  void postGuestDetails(@Body GuestData guestData, Callback<Object> obj);

    
}
