package com.example.hotelreservationandroidapp.fragments;

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

import com.example.hotelreservationandroidapp.network.response.HotelListAdapter;
import com.example.hotelreservationandroidapp.model.HotelListData;
import com.example.hotelreservationandroidapp.ItemClickListener;
import com.example.hotelreservationandroidapp.R;
import com.example.hotelreservationandroidapp.network.service.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelsListFragment extends Fragment implements ItemClickListener {

    View view;
    TextView headingTextView;
    ProgressBar progressBar;
    List<HotelListData> userListResponseData;
    Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_list_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //heading text view
        headingTextView = view.findViewById(R.id.heading_text_view);
        progressBar = view.findViewById(R.id.progress_bar);

        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        String numberOfGuests = getArguments().getString("number of guests");
         bundle = new Bundle();
        bundle.putString("checkInDate", checkInDate);
        bundle.putString("checkOutDate", checkOutDate);

        //Set up the header
        headingTextView.setText("Welcome, displaying hotel for " + numberOfGuests + " guests staying from " + checkInDate +
                " to " + checkOutDate);


        // Set up the RecyclerView
//        ArrayList<HotelListData> hotelListData = initHotelListData();
//        RecyclerView recyclerView = view.findViewById(R.id.hotel_list_recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), hotelListData);
//        recyclerView.setAdapter(hotelListAdapter);
        getHotelsListsData();
    }

    public ArrayList<HotelListData> initHotelListData() {
        ArrayList<HotelListData> list = new ArrayList<>();

        list.add(new HotelListData("Halifax Regional Hotel", Integer.parseInt("2000"), Boolean.parseBoolean("true")));
        list.add(new HotelListData("Hotel Pearl", Integer.parseInt("500"), Boolean.parseBoolean("false")));
        list.add(new HotelListData("Hotel Amano", Integer.parseInt("800"), Boolean.parseBoolean("true")));
        list.add(new HotelListData("San Jones", Integer.parseInt("250"), Boolean.parseBoolean("false")));
        list.add(new HotelListData("Halifax Regional Hotel", Integer.parseInt("2000"), Boolean.parseBoolean("true")));
        list.add(new HotelListData("Hotel Pearl", Integer.parseInt("500"), Boolean.parseBoolean("false")));
        list.add(new HotelListData("Hotel Amano", Integer.parseInt("800"), Boolean.parseBoolean("true")));
        list.add(new HotelListData("San Jones", Integer.parseInt("250"), Boolean.parseBoolean("false")));

        return list;
    }

    private void getHotelsListsData() {
        progressBar.setVisibility(View.VISIBLE);
        Api.getClient().getHotelsLists(new Callback<List<HotelListData>>() {
            @Override
            public void success(List<HotelListData> userListResponses, Response response) {
                // in this method we will get the response from API
                userListResponseData = userListResponses;


                // Set up the RecyclerView
                setupRecyclerView();
            }

            @Override
            public void failure(RetrofitError error) {
                // if error occurs in network transaction then we can get the error in this method.
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void setupRecyclerView() {
        progressBar.setVisibility(View.GONE);
        RecyclerView recyclerView = view.findViewById(R.id.hotel_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), userListResponseData);
        recyclerView.setAdapter(hotelListAdapter);

        //Bind the click listener
        hotelListAdapter.setClickListener(this);
    }


    @Override
    public void onClick(View view, int position) {
        HotelListData hotelListData = userListResponseData.get(position);

        String hotelName = hotelListData.getHotel_name();
        String price = String.valueOf(hotelListData.getPrice());
        String availability = String.valueOf(hotelListData.getAvailability());


        bundle.putString("hotel name", hotelName);
        bundle.putString("hotel price", price);
        bundle.putString("hotel availability", availability);

        HotelGuestDetailsFragment hotelGuestDetailsFragment = new HotelGuestDetailsFragment();
        hotelGuestDetailsFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(HotelsListFragment.this);
        fragmentTransaction.replace(R.id.main_layout, hotelGuestDetailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();

    }
}
