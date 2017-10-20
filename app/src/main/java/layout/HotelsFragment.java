package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.re_coded.example.android.kirkukcity.Landmark;
import com.re_coded.example.android.kirkukcity.LandmarkArrayAdapter;
import com.re_coded.example.android.kirkukcity.LocationFragment;
import com.re_coded.example.android.kirkukcity.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HotelsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HotelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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
        landmarks.add(new Landmark("44.39377","35.478778","Baladiya St, In front of Jennet sweets","Alsanawbar",R.drawable.ic_alsanawbar,"Al-Sanawbar is located in the heart of Kirkuk and has been known for its good service and low price"));
        landmarks.add(new Landmark("44.37955","35.461308","Tisin st, Near kardaslik school","Kirkuk Plaza",R.drawable.ic_kirkukplaza,"KirkukPlaza is located in the heart of Kirkuk and has been known for its good service and low price"));

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
