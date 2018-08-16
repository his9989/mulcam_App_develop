package com.multi.student.sceen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void goNext(View v){
        //Toast.makeText(this,"click.....",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,Next.class);
        i.putExtra("key","정유미");
        startActivity(i);
    }
    public void goService(View v){
        Intent i = new Intent(this,MyService.class);
        startService(i);
    }
    public void finishService(View v){
        Intent i = new Intent(this, MyService.class);
        stopService(i);
    }

    public void goCast(View v){
        Intent i = new Intent(this,MyReceiver.class);
        sendBroadcast(i);
    }
}
