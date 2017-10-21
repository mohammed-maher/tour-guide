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

public class LocationFragment extends Fragment {

    OnLocationSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnLocationSelectedListener {
        public void onLocationSelected(Context context, int position, ArrayList<Landmark> array);
    }

    public LocationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_location, container, false);

        final ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
        landmarks.add(new Landmark("44.395777", "35.469778", getString(com.re_coded.example.android.kirkukcity.R.string.kirkuk_citadel_address), getString(com.re_coded.example.android.kirkukcity.R.string.kirkuk_citadel_name), R.drawable.ic_kirkukcitadel, getString(com.re_coded.example.android.kirkukcity.R.string.about_kirkuk_citadel)));
        landmarks.add(new Landmark("44.379659", "35.461308", getString(com.re_coded.example.android.kirkukcity.R.string.sacred_heart_address), getString(com.re_coded.example.android.kirkukcity.R.string.sacred_heart_name), R.drawable.ic_sacredheart, getString(com.re_coded.example.android.kirkukcity.R.string.about_sacred_heart)));
        landmarks.add(new Landmark("44.373968", "35.425687", getString(com.re_coded.example.android.kirkukcity.R.string.alnoor_mosque_address), getString(com.re_coded.example.android.kirkukcity.R.string.alnoor_mosque_name), R.drawable.ic_alnoormosque, getString(com.re_coded.example.android.kirkukcity.R.string.about_alnoor_sacred_heart)));
        landmarks.add(new Landmark("44.388558", "35.471213", getString(com.re_coded.example.android.kirkukcity.R.string.qishla_address), getString(com.re_coded.example.android.kirkukcity.R.string.qishla_name), R.drawable.ic_qashla, getString(com.re_coded.example.android.kirkukcity.R.string.about_qishla)));

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
            mCallback = (OnLocationSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnLocationSelectedListener");
        }
    }
}
