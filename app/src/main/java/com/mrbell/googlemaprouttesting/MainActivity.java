package com.mrbell.googlemaprouttesting;

import android.Manifest;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {


    FusedLocationProviderClient fusedLocationProviderClient;
    Location mlocation;
    Gpsroutin gpsroutin;


    SupportMapFragment mapFragment;
    Marker oldMarker,newMarker;
    CameraUpdate cameraUpdate;
    MarkerOptions markerOptions;
    LatLng ll;

    GoogleMap gMap;

    String[]permision = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION

    };
    final int RC_PERMISSION= 100;
    ImageButton fab;
    Button btn_mirpur,btn_uttara,btn_wari;
    EditText editText;


    ArrayList<Marker>arrymarker = new ArrayList<>();
    ArrayList<HashMap<String,String>> arraylocation = new ArrayList<>();
    ArrayList<HashMap<String,String>> arraySteps=new ArrayList<>();

    String url ="https://maps.googleapis.com/map/api/place/textsearch/json?" + "key=AIzaSyBgZTnamFOQng2HZSQKqxIRhmeCmyD5qAI" +"&query=";
    String url2="https://maps.googleapis.com/map/api/place/textsearch/json?"+"key=AIzaSyBgZTnamFOQng2HZSQKqxIRhmeCmyD5qAI";


    String MODE_DRIVIES="driving";
    String urlQuery="";

    int firsttimeshow=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
