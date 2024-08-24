package com.upb.mirestaurante_dondetono;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upb.mirestaurante_dondetono.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        mMap = googleMap;

        // Add a marker in Medellin and move the camera
        LatLng medellin = new LatLng( 6.251, -75.563);
        LatLng laureles2 = new LatLng(6.247246, -75.594845);
        LatLng laureles = new LatLng(6.247482, -75.594482);
        LatLng laureles3 = new LatLng(6.247141, -75.594696);

        mMap.addMarker(new MarkerOptions().position(laureles2).title("Marker in laureles2"));
        mMap.addMarker(new MarkerOptions().position(laureles).title("Marker in laureles"));
        mMap.addMarker(new MarkerOptions().position(laureles3).title("Marker in poblado"));
        mMap.addMarker(new MarkerOptions().position(medellin).title("Marker in medellin"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(laureles,18));


        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

    }
}