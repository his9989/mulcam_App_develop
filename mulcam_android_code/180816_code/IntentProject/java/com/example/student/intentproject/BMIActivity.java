package com.example.student.intentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BMIActivity extends AppCompatActivity {

    EditText Height, Weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        Height = (EditText) findViewById(R.id.height);
        Weight = (EditText) findViewById(R.id.weight);
    }

    // 화면에 입력한 값을 인텐트에 담아서 BMICheckActivity로 보냄
    public void send(View v){
        String height = Height.getText().toString();
        String weight = Weight.getText().toString();

        Intent i = new Intent(this, BMICheckActivity.class);

        i.putExtra("Height", height);
        i.putExtra("Weight", weight);

        startActivity(i);
    }
}
