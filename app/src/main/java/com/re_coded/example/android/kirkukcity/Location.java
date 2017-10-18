package com.re_coded.example.android.kirkukcity;

/**
 * Created by Lenovo on 10/14/2017.
 */

public class Location {
    private String locationLongitude;
    private String locationLatitude;
    private String locationAddress;

    public Location(String llocationLongitude, String locationLatitude, String locationAddress) {
        this.locationLongitude = llocationLongitude;
        this.locationLatitude = locationLatitude;
        this.locationAddress = locationAddress;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public void setLocationLongitude(String llocationLongitude) {
        this.locationLongitude = llocationLongitude;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }
}
