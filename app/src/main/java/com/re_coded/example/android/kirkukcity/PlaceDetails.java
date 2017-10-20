package com.re_coded.example.android.kirkukcity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        Bundle extras = getIntent().getExtras();

        if (extras == null) {
            return;
        }

        final String locationName = extras.getString("TITLE");
        int locationImage = extras.getInt("IMAGE");
        String locationDescription = extras.getString("DESCRIPTION");
        final String locationLng = extras.getString("LONGITUDE");
        final String locationLat = extras.getString("LATITUDE");
        String locationAdress = extras.getString("ADDRESS");

        this.setTitle(locationName);

        ImageView headerImage = (ImageView) findViewById(R.id.header_image);
        TextView titleText = (TextView) findViewById(R.id.title_text);
        TextView addressText = (TextView) findViewById(R.id.address_text);
        TextView descriptionText = (TextView) findViewById(R.id.description_text);
        Button viewMap = (Button) findViewById(R.id.map_button);
        Button backButton = (Button) findViewById(R.id.back_button);

        headerImage.setImageResource(locationImage);
        titleText.setText(locationName);
        addressText.setText(locationAdress);
        descriptionText.setText(locationDescription);

        viewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = "http://maps.google.com/maps?q=loc:" + locationLat + "," + locationLng + " (" + locationName + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                v.getContext().startActivity(intent);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

    }
}
