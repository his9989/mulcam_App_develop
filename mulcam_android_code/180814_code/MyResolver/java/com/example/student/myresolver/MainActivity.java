package com.example.student.myresolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String authory = "com.edu.multi";
    Uri myUri = Uri.parse("content://"+authory);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View v){
        ContentResolver r = getContentResolver();
        r.insert(myUri, new ContentValues());
        // uri : contentProvider를 찾아가는 주소. 즉, 코드의 위치를 적어둔 값으로, 다른 프로젝트에서 사용할 때 사용되는 개념인 듯
    }

    public void update(View v){
        ContentResolver r = getContentResolver();
        r.update(myUri, new ContentValues(), null, null);
    }

    public void delete(View v){
        ContentResolver r = getContentResolver();
        r.delete(myUri, null, null);
    }

    public void query(View v){
        ContentResolver r = getContentResolver();
        r.query(myUri, null, null, null, null);
    }
}
