package com.example.kimsm.buskingproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class HongikListActivity extends AppCompatActivity {

    ImageView artisbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hongik_list);
        ListView listView;
        ListViewAdapter adapter;
        artisbutton = (ImageView)findViewById(R.id.artistbutton);
        artisbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(HongikListActivity.this, HongikGridActivity.class);
                startActivity(j);
            }
        });
        adapter = new ListViewAdapter();

        listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.band),"공연시각  :  19:00  ~  20:00 ","어쿠스틱 콜라보 : 묘해 너와 ");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.dance),"공연시각  :  20:00  ~  21:00 ","아이유 : 이름에게 ");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.gd),"공연시각  :  20:00  ~  21:30 ","GD : heartbreaker~ ");
    }

    public void go_Grid(View view) {

    }

    public void go_Map(View view) {
        Intent i = new Intent(HongikListActivity.this, HongikMapDataActivity.class);
        startActivity(i);
    }
}
