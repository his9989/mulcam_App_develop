package com.example.kimsm.buskingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class loadingActivity extends AppCompatActivity {

     Intent intent;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_loading);

      intent = new Intent(loadingActivity.this,MainActivity.class);

      try{
        Thread.sleep(2000);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
      startActivity(intent);
      }
}
