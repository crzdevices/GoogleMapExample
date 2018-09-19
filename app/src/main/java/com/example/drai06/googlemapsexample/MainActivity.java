package com.example.drai06.googlemapsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng udea = new LatLng(6.267854, -75.569023);
        mMap.addMarker(new MarkerOptions()
                .position(udea)
                .title("Marker in UdeA")
                .snippet("Alma Mater"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udea, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }
}
