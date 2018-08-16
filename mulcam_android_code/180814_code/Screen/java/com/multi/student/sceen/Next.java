package com.multi.student.sceen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Next extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent i = getIntent();
        String name = i.getStringExtra("key");
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
    }
}
