package com.example.hotelreservationandroidapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelreservationandroidapp.ItemClickListener;
import com.example.hotelreservationandroidapp.R;
import com.example.hotelreservationandroidapp.model.HotelListData;
import com.example.hotelreservationandroidapp.network.response.HotelListAdapter;
import com.example.hotelreservationandroidapp.network.service.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelConfirmationFragment extends Fragment  {

    View view;
    TextView headingTextView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_confirmation_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //heading text view
        headingTextView = view.findViewById(R.id.confirmation);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
        String otp = sharedPreferences.getString("OTP", "ABC");
headingTextView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        //Set up the header
        headingTextView.setText("Thank you for your reservation, your \n" +
                "reservation number is "+otp);


        // Set up the RecyclerView
//        ArrayList<HotelListData> hotelListData = initHotelListData();
//        RecyclerView recyclerView = view.findViewById(R.id.hotel_list_recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), hotelListData);
//        recyclerView.setAdapter(hotelListAdapter);

    }




}
