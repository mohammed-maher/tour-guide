package com.re_coded.example.android.kirkukcity;

import java.io.Serializable;

/**
 * Created by Lenovo on 10/14/2017.
 */

public class Landmark extends Location implements Serializable {
    private String name;
    private int image;
    private String description;

    public Landmark(String locationLongitude, String locationLatitude, String locationAddress, String name, int image, String description) {
        super(locationLongitude, locationLatitude, locationAddress);
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
