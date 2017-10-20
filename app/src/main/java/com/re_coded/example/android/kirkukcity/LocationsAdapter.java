package com.re_coded.example.android.kirkukcity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import layout.HotelsFragment;

/**
 * Created by Lenovo on 10/18/2017.
 */

public class LocationsAdapter extends FragmentPagerAdapter {
    public LocationsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LocationFragment();

            case 1:
                return new RestaurantFragment();

            case 2:
                return new HotelsFragment();

            case 3:
                return new MallsFragment();

            default:
                return new LocationFragment();

        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence[] titles = {"Landmarks", "Restaurants", "Hotels", "Malls"};
        return titles[position];
    }
}
