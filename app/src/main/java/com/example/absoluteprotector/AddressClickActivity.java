package com.example.absoluteprotector;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddressClickActivity extends AppCompatActivity  implements LocationListener{
    TextView tv9,tv12,tv2,tv4,t2v2,tv24,tv8;
TextView adr,latitude,longitude;
    Geocoder geocoder;
    ImageView back_button;
    String str;
    public static final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_click);
        tv9=(TextView) findViewById(R.id.tv91);
        tv12=(TextView)findViewById(R.id.tv13);
adr=findViewById(R.id.adr);
latitude=findViewById(R.id.latitude);
longitude=findViewById(R.id.longitude);
        tv4=(TextView)findViewById(R.id.tv4);
      //  t2v2=(TextView)findViewById(R.id.tv22);
        tv24=(TextView)findViewById(R.id.tv24);
        tv8=(TextView)findViewById(R.id.tv8);
        batteryLevel();
//        BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
//        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yy");
        String format = s1.format(new Date());
        SimpleDateFormat s2 = new SimpleDateFormat("hh:mm:ss");
        String format1 = s2.format(new Date());
        tv9.setText(format);
        tv12.setText(format1);
        back_button=findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        if (checkPermissions()) {
            getLocation();

        } else {  //No user has not granted the permissions yet. Request now.
            requestPermissions();
        }

        getLocation();

    }
    private void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5,  AddressClickActivity.this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    public void onLocationChanged(Location location) {
        // locationText = ("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());
        //locationText = ("Latitude: " + location.getLatitude() + "Longitude: " + location.getLongitude());
        //Mylocation.setText(locationText);
        double a = location.getLatitude();
        double b = location.getLongitude();
        String n = a+"";
        String l = b+"";

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
//            String countryCode = addresses.get(0).getCountryCode(
            latitude.setText(n);
            longitude.setText(l);

adr.setText(address);



        } catch (IOException e) {
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


    private boolean checkPermissions() {
        int permissionState1 = ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION);

        int permissionState2 = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        return permissionState1 == PackageManager.PERMISSION_GRANTED && permissionState2 == PackageManager.PERMISSION_GRANTED;

    }

    private void requestPermissions() {
        boolean shouldProvideRationale =
                ActivityCompat.shouldShowRequestPermissionRationale(this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);
        boolean shouldProvideRationale2 =
                ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION);

        if (shouldProvideRationale || shouldProvideRationale2) {

        } else {
            ActivityCompat.requestPermissions(AddressClickActivity.this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }
    private void batteryLevel() {
        BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                context.unregisterReceiver(this);
                int rawlevel = intent.getIntExtra("level", -1);
                int scale = intent.getIntExtra("scale", -1);
                int level = -1;
                if (rawlevel >= 0 && scale > 0) {
                    level = (rawlevel * 100) / scale;
                }
                tv8.setText(level + "%");
            }
        };
        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryLevelReceiver, batteryLevelFilter);
    }
}
