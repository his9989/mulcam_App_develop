package com.example.kimsm.buskingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText id_in;
EditText pass_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id_in = (EditText)findViewById(R.id.id_in);
        pass_in = (EditText)findViewById(R.id.pass_in);
    }
    public void login(View v)
    {
        String id = id_in.getText().toString();
        String pass = pass_in.getText().toString();
        Intent i = new Intent(this,UserActivity.class);
        i.putExtra("id",id);
        i.putExtra("pass",pass);
        startActivity(i);
    }
    public void signup(View v)
    {
        Intent i = new Intent(this,SignupActivity.class);
        startActivity(i);
    }
}
