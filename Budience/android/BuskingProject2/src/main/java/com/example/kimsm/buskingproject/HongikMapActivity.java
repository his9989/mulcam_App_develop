package com.example.kimsm.buskingproject;

import android.Manifest;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HongikMapActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener{

    FusedLocationProviderClient mFusedLocationClient;
    LocationCallback mLocationCallback;
    Location mCurrentLocation;
    GoogleMap Mmap;
    boolean mLocationPermissionGranted;
    LocationRequest mLocationRequest;
    LocationManager manager;
    ArrayList<String> locx;
    ArrayList<String> locy;
    ArrayList<String> startti;
    ArrayList<String> endti;
    ArrayList<String> teamname;
    ArrayList<String>  info;
    ArrayList<String> genre;
    TextView tvteamname;
    TextView tvteaminfo;
    Time time;
    String formatDate;
    Map<String, String> markerinfo;
    ImageView artistImage;
    ArrayList<Integer> imageR;
    Map<String, Integer> imageinfo;
    ImageView listbutton;
    ImageView artistbutton;
    ImageView mapbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hongik_map);


        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        manager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Intent i =getIntent();

        locx = i.getStringArrayListExtra("locx");
        locy = i.getStringArrayListExtra("locy");
        startti = i.getStringArrayListExtra("startti");
        endti = i.getStringArrayListExtra("endti");
        teamname = i.getStringArrayListExtra("teamname");
        info = i.getStringArrayListExtra("info");
        genre = i.getStringArrayListExtra("genre");
        tvteamname = (TextView)findViewById(R.id.tvteamname);
        tvteaminfo = (TextView)findViewById(R.id.tvteaminfo);
        markerinfo = new HashMap<String, String>();
        listbutton = (ImageView)findViewById(R.id.listbutton);
        artistbutton = (ImageView)findViewById(R.id.artistbutton);
        mapbutton = (ImageView)findViewById(R.id.mapbutton);
        artistImage = (ImageView)findViewById(R.id.artistimage);
        imageR = new ArrayList<>();
        imageR.add(R.drawable.hyukoband);
        imageR.add(R.drawable.beenzino);
        imageR.add(R.drawable.bigbang);
        imageR.add(R.drawable.gdragon);
        imageR.add(R.drawable.hyoshinpark);
        imageR.add(R.drawable.magic);
        imageR.add(R.drawable.neighbourhood);
        imageR.add(R.drawable.nell);
        imageR.add(R.drawable.thexx);
        imageR.add(R.drawable.hyukoband2);
        imageinfo = new HashMap<String, Integer>();
        listbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HongikMapActivity.this, "list button", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HongikMapActivity.this, HongikListActivity.class);
                startActivity(i);
            }
        });
        artistbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HongikMapActivity.this, "artist button", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HongikMapActivity.this, HongikGridActivity.class);
                startActivity(i);
            }
        });
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HongikMapActivity.this, "mapbutton", Toast.LENGTH_SHORT).show();
        }
        });
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm:ss");
        formatDate = sdfNow.format(date);
    }

    @Override
    public void onMapReady(GoogleMap map) {

        Mmap = map;
        Toast.makeText(this,"현재위치",Toast.LENGTH_LONG).show();

        MarkerOptions markerOptions = new MarkerOptions();
        for(int i=0;i<locx.size();i++)
        {
            LatLng loc = new LatLng(Double.parseDouble(locx.get(i)),Double.parseDouble(locy.get(i)));
            markerOptions.position(loc);
            markerOptions.title(teamname.get(i));
            if((formatDate.compareTo(startti.get(i))>=0)&&(formatDate.compareTo(endti.get(i))<0))
            {
                imageinfo.put(teamname.get(i),imageR.get(i));
                markerinfo.put(teamname.get(i),"장르 : "+genre.get(i)+"\n공연정보 : "+info.get(i)+"\n현재 공연중, "+endti.get(i)+"에 종료예정");
                markerOptions.snippet(info.get(i)+"\n"+"공연중");
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                map.addMarker(markerOptions);
                map.setOnMarkerClickListener(this);
            }
            else if(formatDate.compareTo(startti.get(i))<0) {
                imageinfo.put(teamname.get(i),imageR.get(i));
                markerinfo.put(teamname.get(i),"장르 : "+genre.get(i)+"\n공연정보 : "+info.get(i)+"\n공연예정시간 : "+startti.get(i)+"~"+endti.get(i));
                markerOptions.snippet(info.get(i) + "\n" + startti.get(i) + "에 공연 예정");
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
                map.addMarker(markerOptions);
                map.setOnMarkerClickListener(this);
            }
//            else if(formatDate.compareTo(endti.get(i))>=0)
//            {
//                markerinfo.put(teamname.get(i),"장르 : "+genre.get(i)+"\n공연정보 : "+info.get(i)+"\n종료된 공연입니다.");
//                markerOptions.snippet(info.get(i)+"\n"+"공연 종료");
//                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
//            }
            if(i==0)
            {   map.moveCamera(CameraUpdateFactory.newLatLng(loc));
                map.animateCamera(CameraUpdateFactory.zoomTo(17));}
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        tvteamname.setText(marker.getTitle());
        tvteaminfo.setText(markerinfo.get(marker.getTitle()));
        artistImage.setImageResource(imageinfo.get(marker.getTitle()));
        return true;
    }
}
