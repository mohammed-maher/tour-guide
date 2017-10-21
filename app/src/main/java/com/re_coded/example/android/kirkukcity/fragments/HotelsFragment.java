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


public class HotelsFragment extends Fragment {
    LocationFragment.OnLocationSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnLocationSelectedListener {
        public void onLocationSelected(Context context,int position,ArrayList<Landmark> array);
    }

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_hotels, container, false);

        final ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
        landmarks.add(new Landmark("44.39377","35.478778",getString(com.re_coded.example.android.kirkukcity.R.string.alsanawbar_hotel_address),getString(com.re_coded.example.android.kirkukcity.R.string.alsanawbar_hotel_name),R.drawable.ic_alsanawbar,getString(com.re_coded.example.android.kirkukcity.R.string.about_alsanawbar_hotel)));
        landmarks.add(new Landmark("44.37955","35.461308",getString(com.re_coded.example.android.kirkukcity.R.string.kirkukplaza_hotel_address),getString(com.re_coded.example.android.kirkukcity.R.string.kirkukplaza_hotel_name),R.drawable.ic_kirkukplaza,getString(com.re_coded.example.android.kirkukcity.R.string.about_kirkukplaza_hotel)));

        ListView list = (ListView)layout.findViewById(R.id.places_list);
        LandmarkArrayAdapter adapter = new LandmarkArrayAdapter(getActivity(),R.layout.landmark_list_item,landmarks);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView adapter, View v, int position, long lng){
                mCallback.onLocationSelected(v.getContext(),position,landmarks);
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
