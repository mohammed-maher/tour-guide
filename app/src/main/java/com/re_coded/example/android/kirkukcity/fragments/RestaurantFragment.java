package com.re_coded.example.android.kirkukcity.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.re_coded.example.android.kirkukcity.Landmark;
import com.re_coded.example.android.kirkukcity.LandmarkArrayAdapter;
import com.re_coded.example.android.kirkukcity.R;

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
        landmarks.add(new Landmark("44.390026", "35.476677", getString(com.re_coded.example.android.kirkukcity.R.string.kebab_abdullah_address), getString(com.re_coded.example.android.kirkukcity.R.string.kebab_abdullah_name), R.drawable.ic_screenshot_1, getString(com.re_coded.example.android.kirkukcity.R.string.about_kebab_abdullah)));
        landmarks.add(new Landmark("44.381433", "35.456909", getString(com.re_coded.example.android.kirkukcity.R.string.today_rest_address), getString(com.re_coded.example.android.kirkukcity.R.string.today_rest_name), R.drawable.ic_todayrest, getString(com.re_coded.example.android.kirkukcity.R.string.about_today_rest)));
        landmarks.add(new Landmark("44.368844", "35.572798", getString(com.re_coded.example.android.kirkukcity.R.string.media_restaurant_addres), getString(com.re_coded.example.android.kirkukcity.R.string.media_restaurant_name), R.drawable.ic_mediyarestaurant, getString(com.re_coded.example.android.kirkukcity.R.string.about_media_restaurant)));

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
