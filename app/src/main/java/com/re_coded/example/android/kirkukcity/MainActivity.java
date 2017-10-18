package com.re_coded.example.android.kirkukcity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LocationFragment.OnLocationSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_location);

     getSupportFragmentManager().beginTransaction()
           .replace(R.id.container, new LocationFragment())
            .commit();
}

    @Override
    public void onLocationSelected(Context context,int position,ArrayList<Landmark> landmarks) {
        Intent intent = new Intent(context,PlaceDetails.class);
        intent.putExtra("TITLE",landmarks.get(position).getName());
        intent.putExtra("IMAGE",landmarks.get(position).getImage());
        intent.putExtra("DESCRIPTION",landmarks.get(position).getDescription());
        intent.putExtra("ADDRESS",landmarks.get(position).getLocationAddress());
        intent.putExtra("LONGITUDE",landmarks.get(position).getLocationLongitude());
        intent.putExtra("LATITUDE",landmarks.get(position).getLocationLatitude());
        context.startActivity(intent);
    }
}
