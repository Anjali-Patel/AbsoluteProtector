package com.example.absoluteprotector;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LocationLogActivity extends AppCompatActivity implements LocationListener {
    ImageView back_button, arrow;
    TextView Date, address1;
    Geocoder geocoder;
    LocationManager locationManager;


    String date1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_log);
        arrow = findViewById(R.id.arrow);
        address1 = findViewById(R.id.address);
        back_button = findViewById(R.id.back_button);
        Date = findViewById(R.id.date);
        //  time=findViewById(R.id.time);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocationLogActivity.this, AddressClickActivity.class);
                startActivity(intent);
            }
        });
        Date date = new Date();
        String stringDate = DateFormat.getDateTimeInstance().format(date);
        SimpleDateFormat s2 = new SimpleDateFormat("hh:mm:ss");
        // String format1 = s2.format(new Date());
        Date.setText(stringDate);
        getLocation();

    }
    private void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5,  LocationLogActivity.this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
//            String knownName = addresses.get(0).getFeatureName();

            List<String> CompleteAddr = Arrays.asList(address.split(","));

            address1.setText(CompleteAddr.get(0));
            //address1.setText(address);


        }catch(Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
