package com.example.student.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        city = (TextView)findViewById(R.id.city);
    }

    public void findCity(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivityForResult(i, 100);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        String cname = data.getStringExtra("city").toString();
        city.setText(cname);
    }
}
