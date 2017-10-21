package com.re_coded.example.android.kirkukcity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.re_coded.example.android.kirkukcity.fragments.LocationFragment;
import com.re_coded.example.android.kirkukcity.fragments.MallsFragment;
import com.re_coded.example.android.kirkukcity.fragments.RestaurantFragment;

import com.re_coded.example.android.kirkukcity.fragments.HotelsFragment;

/**
 * Created by Lenovo on 10/18/2017.
 */

public class LocationsAdapter extends FragmentPagerAdapter {

    private Context mContext;
    public LocationsAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.mContext = context;
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
        CharSequence[] titles = {mContext.getString(R.string.landmarks_title), mContext.getString(R.string.restaurants_title), mContext.getString(R.string.hotels_title), mContext.getString(R.string.malls_title)};
        return titles[position];
    }
}
