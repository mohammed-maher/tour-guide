package com.re_coded.example.android.kirkukcity.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.re_coded.example.android.kirkukcity.R;
import com.re_coded.example.android.kirkukcity.Landmark;
import com.re_coded.example.android.kirkukcity.LandmarkArrayAdapter;

import java.util.ArrayList;


public class MallsFragment extends Fragment {

    public MallsFragment() {
        // Required empty public constructor
    }

    LocationFragment.OnLocationSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnLocationSelectedListener {
        public void onLocationSelected(Context context, int position, ArrayList<Landmark> array);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_location, container, false);

        final ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
        landmarks.add(new Landmark("44.381781", "35.458698", getString(com.re_coded.example.android.kirkukcity.R.string.ghazimall_address), getString(com.re_coded.example.android.kirkukcity.R.string.ghazimall_name), R.drawable.ic_ghazimall, getString(com.re_coded.example.android.kirkukcity.R.string.about_ghazimall)));
        landmarks.add(new Landmark("44.389052", "35.475813", getString(com.re_coded.example.android.kirkukcity.R.string.lcwaikiki_address), getString(com.re_coded.example.android.kirkukcity.R.string.lcwaikiki_name), R.drawable.ic_lcwaikiki, getString(com.re_coded.example.android.kirkukcity.R.string.about_lcwaikiki)));
        landmarks.add(new Landmark("35.458526", "44.381439", getString(com.re_coded.example.android.kirkukcity.R.string.maximall_address), getString(com.re_coded.example.android.kirkukcity.R.string.maximall_name), R.drawable.ic_maximall, getString(com.re_coded.example.android.kirkukcity.R.string.about_maximall)));

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
