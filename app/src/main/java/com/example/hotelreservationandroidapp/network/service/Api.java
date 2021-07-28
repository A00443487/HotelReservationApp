package com.example.hotelreservationandroidapp.network.service;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class Api {

    public static ApiInterface getClient() {

        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/
        // change your base URL
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://ec2-52-60-50-87.ca-central-1.compute.amazonaws.com:8080/") //Set the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        ApiInterface api = adapter.create(ApiInterface.class);
        return api; // return the APIInterface object
    }
}
