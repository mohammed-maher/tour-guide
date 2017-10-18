package com.re_coded.example.android.kirkukcity;

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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LocationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public LocationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LocationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LocationFragment newInstance(String param1, String param2) {
        LocationFragment fragment = new LocationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
                Intent intent = new Intent(getActivity(),PlaceDetails.class);
                intent.putExtra("TITLE",landmarks.get(position).getName());
                intent.putExtra("IMAGE",landmarks.get(position).getImage());
                intent.putExtra("DESCRIPTION",landmarks.get(position).getDescription());
                intent.putExtra("ADDRESS",landmarks.get(position).getLocationAddress());
                intent.putExtra("LONGITUDE",landmarks.get(position).getLocationLongitude());
                intent.putExtra("LATITUDE",landmarks.get(position).getLocationLatitude());
                v.getContext().startActivity(intent);
            }

        });
        return layout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
