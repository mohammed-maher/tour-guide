package com.re_coded.example.android.kirkukcity;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 10/14/2017.
 */

public class LandmarkArrayAdapter extends ArrayAdapter<Landmark> {

    List<Landmark> landmarks = new ArrayList<>();

    public LandmarkArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Landmark> list) {
        super(context, resource, list);
        this.landmarks = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitem = convertView;

        if (listitem == null) {
            listitem = LayoutInflater.from(getContext()).inflate(R.layout.landmark_list_item, parent, false);
        }

        Typeface tf = Typeface.createFromAsset(listitem.getContext().getAssets(), "fonts/Roboto-Regular.ttf");
        ImageView image = (ImageView) listitem.findViewById(R.id.place_image);
        TextView title = (TextView) listitem.findViewById(R.id.title_text_view);

        title.setTypeface(tf);

        TextView address = (TextView) listitem.findViewById(R.id.address_text_view);
        Landmark item = (Landmark) landmarks.get(position);
        image.setImageResource(item.getImage());
        title.setText(item.getName());

        address.setText(item.getLocationAddress());
        return listitem;
    }
}
