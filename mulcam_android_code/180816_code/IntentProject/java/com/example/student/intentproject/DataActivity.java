package com.example.student.intentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        message = (TextView)findViewById(R.id.message);

        Intent i = getIntent(); // intent 받기
        String code = i.getStringExtra("code");
        int count = i.getIntExtra("count", 0);

        message.setText(code + count);
    }

    public void back(View v){
        Intent i = new Intent();
        i.putExtra("result", "well done..");
        setResult(1, i);
        finish();
    }

}
