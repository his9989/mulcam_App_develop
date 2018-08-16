package com.example.student.intentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BMICheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicheck);

        TextView result_message;
        ImageView result_image;

        Intent i = getIntent(); // intent 받기
        String height2 = i.getStringExtra("Height");
        String weight2 = i.getStringExtra("Weight");

        int height = Integer.parseInt(height2);
        int weight = Integer.parseInt(weight2);

        double BMI = (double) weight / ((double) height * 0.01 * (double) height * 0.01);

        result_message = (TextView)findViewById(R.id.result_message);
        result_image = (ImageView)findViewById(R.id.result_image);

        if(BMI>30.0){
            result_message.setText("고도비만입니다.");
            result_image.setImageResource(R.mipmap.fatfat);
        } else if(23.0<BMI && BMI<29.9){
            result_message.setText("비만입니다.");
            result_image.setImageResource(R.mipmap.fat);
        } else if(18.5<BMI && BMI<22.9){
            result_message.setText("정상입니다.");
            result_image.setImageResource(R.mipmap.good);
        } else {
            result_message.setText("저체중입니다.");
            result_image.setImageResource(R.mipmap.thin);
        }
    }

    public void back(View v){
        finish();
    }
}
