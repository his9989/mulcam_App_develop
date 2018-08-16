package com.example.student.intentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_check);

        //LoginActivity에서 보내온 intent안에 값 꺼내서 비교
        //resiltCode를 다르게 저장
        //돌아가기


        Intent i = getIntent(); // intent 받기
        String ID = i.getStringExtra("UserID");
        String PW = i.getStringExtra("UserPW");

        if(ID.equals("his9989") && PW.equals("1234")){
            setResult(1);
        } else{
            setResult(2);
        }
        finish();
    }
}
