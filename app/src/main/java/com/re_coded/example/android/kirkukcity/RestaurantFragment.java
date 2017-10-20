package com.re_coded.example.android.kirkukcity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class RestaurantFragment extends Fragment {

    LocationFragment.OnLocationSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnLocationSelectedListener {
        public void onLocationSelected(Context context, int position, ArrayList<Landmark> array);
    }

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_location, container, false);

        final ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
        landmarks.add(new Landmark("44.390026", "35.476677", "Entry of Komari Street", "Abdullah's Kebab", R.drawable.ic_screenshot_1, "Abdullah's Kebab is a retaurant in Kirkuk that provides a wide range of foods and drinks "));
        landmarks.add(new Landmark("44.381433", "35.456909", "Baghdad Rd, Kirkuk", "Today Restaurant&Cafe", R.drawable.ic_todayrest, "Today is a retaurant in Kirkuk that provides a wide range of foods and drinks "));
        landmarks.add(new Landmark("44.368844", "35.572798", "Kirkuk, entry of erbil Road", "Media Tourist Restaurant", R.drawable.ic_mediyarestaurant, "Media is tourist restaurant and one of the largest restaurants in Kirkuk, Its well known by its turkish professional turkish staff."));

        ListView list = (ListView) layout.findViewById(R.id.places_list);
        LandmarkArrayAdapter adapter = new LandmarkArrayAdapter(getActivity(), R.layout.landmark_list_item, landmarks);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapter, View v, int position, long lng) {
                mCallback.onLocationSelected(v.getContext(), position, landmarks);
            }

        });
        return layout;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        try {
            mCallback = (LocationFragment.OnLocationSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnLocationSelectedListener");
        }
    }
}
