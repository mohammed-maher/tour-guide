package com.re_coded.example.android.kirkukcity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.re_coded.example.android.kirkukcity.fragments.LocationFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LocationFragment.OnLocationSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        LocationsAdapter locationsAdapter = new LocationsAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(locationsAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onLocationSelected(Context context, int position, ArrayList<Landmark> landmarks) {
        Intent intent = new Intent(context, PlaceDetailsActivity.class);
        intent.putExtra("TITLE", landmarks.get(position).getName());
        intent.putExtra("IMAGE", landmarks.get(position).getImage());
        intent.putExtra("DESCRIPTION", landmarks.get(position).getDescription());
        intent.putExtra("ADDRESS", landmarks.get(position).getLocationAddress());
        intent.putExtra("LONGITUDE", landmarks.get(position).getLocationLongitude());
        intent.putExtra("LATITUDE", landmarks.get(position).getLocationLatitude());
        context.startActivity(intent);
    }
}
