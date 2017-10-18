package com.re_coded.example.android.kirkukcity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LocationFragment extends Fragment {

    OnLocationSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnLocationSelectedListener {
        public void onLocationSelected(Context context,int position,ArrayList<Landmark> array);
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
        landmarks.add(new Landmark("44.395777","35.469778"," Center of Kirkuk","Kirkuk Citadel",R.drawable.ic_kirkukcitadel,"The Kirkuk Citadel is located in the centre of the city of Kirkuk in Iraq, and is considered to be the oldest part of the city. The citadel stands on an artificial mound 130 feet high located on a plateau across the Khasa River. The mound, or tell, is believed to have been built by King Ashurnasirpal II between 884 and 858 BCE as a military defence line of Arrapha."));
        landmarks.add(new Landmark("44.379659","35.461308","Almuhafaza Street, Behind Hikma Hospital","Sacred Heart Cathedral",R.drawable.ic_sacredheart,"Sacred Heart was established in 1964 and is the largest of 7 churches in kirkuk"));
        landmarks.add(new Landmark("44.373968","35.425687","Baghdad Road, In front of Afandi building","Alnoor Mosque",R.drawable.ic_alnoormosque,"Alnoor was built in 1998 by Rafiq Shafiq, With total area of 2500m² and 5 domes, It's know to be the largest mosque in the city"));
        landmarks.add(new Landmark("44.388558","35.471213","Entry of Republic Road","Qishla",R.drawable.ic_qashla,"The Qishla was built in 1863 to be the headquarters of the Ottoman army in Kirkuk. The building is located in the city centre, occupying about 6 acres (24,000 m2). The word Qishla is a Turkish word means the place where the army stay at the winter."));
        landmarks.add(new Landmark("44.388558","35.471213","Entry of Republic Road","Qishla",R.drawable.ic_qashla,"The Qishla was built in 1863 to be the headquarters of the Ottoman army in Kirkuk. The building is located in the city centre, occupying about 6 acres (24,000 m2). The word Qishla is a Turkish word means the place where the army stay at the winter."));

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
            mCallback = (OnLocationSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnLocationSelectedListener");
        }
    }
}
