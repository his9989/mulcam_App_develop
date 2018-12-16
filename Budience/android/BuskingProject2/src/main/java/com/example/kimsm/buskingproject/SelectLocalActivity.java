package com.example.kimsm.buskingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectLocalActivity extends AppCompatActivity {

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_local);
        Intent i = getIntent();
        id = i.getStringExtra("id");
    }

    public void go_hongik(View view) {
        Intent i = new Intent(SelectLocalActivity.this, HongikGridActivity.class);
        i.putExtra("id",id);
        startActivity(i);
    }
}
