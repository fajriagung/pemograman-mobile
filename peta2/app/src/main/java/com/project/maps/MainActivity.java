package com.project.maps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {

    private GoogleMap map;

    private LatLng latLngBiru = new LatLng(-6.984043, 110.410701);
    private LatLng latLngKuning = new LatLng(-6.985289, 110.410724);
    private LatLng latLngsatu = new LatLng(-6.984298, 110.409382);
    private LatLng latLngMerah = new LatLng(35.6839537, 139.7308615);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        map = mapFrag.getMap();
        map.setMyLocationEnabled(true);


        map.addMarker(new MarkerOptions()
                .position(latLngBiru)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Lawang Sewu").snippet("Lokasi Pariwisata"));
        map.addMarker(new MarkerOptions()
                .position(latLngKuning)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Pusat Oleh-Oleh Pandanaran").snippet("Kuliner Semarang"));
        map.addMarker(new MarkerOptions()
                .position(latLngsatu)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Monumen Tugu Muda").snippet("Lokasi Pariwisata"));
        map.addMarker(new MarkerOptions()
                .position(latLngMerah)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .title("kantin kampus").snippet("makan makan"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngBiru, 17));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLngBiru)
                .zoom(17)
                .bearing(0)
                .tilt(45)
                .build();

        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}