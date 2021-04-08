package org.tannahill.gcu.liamtannahill;
//Student Name:Liam Tannahill
//Student ID: 200702799

import androidx.fragment.app.FragmentActivity;


import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap myMap;
    private ArrayList<PullParser> mapList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mapList = (ArrayList<PullParser>) getIntent().getExtras().getSerializable("Items");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override

    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;
        //Default coordinates London
        LatLng uk = new LatLng(51.509865, -0.118092);

        for (int i = 0; i < mapList.size(); i++) {
            BitmapDescriptor bmd = null;

            if (Float.parseFloat(mapList.get(i).getMagnitude()) < 1) {
                bmd = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
            } else if (Float.parseFloat(mapList.get(i).getMagnitude()) >= 1 && Float.parseFloat(mapList.get(i).getMagnitude()) <= 2) {
                bmd = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW);
            } else if (Float.parseFloat(mapList.get(i).getMagnitude()) > 2) {
                bmd = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);
            }
            myMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(mapList.get(i).getLatitude()), Double.parseDouble(mapList.get(i).getLongitude()))).icon(bmd).title(mapList.get(i).getLocation()));
        }
        myMap.moveCamera(CameraUpdateFactory.newLatLng(uk));
    }
}