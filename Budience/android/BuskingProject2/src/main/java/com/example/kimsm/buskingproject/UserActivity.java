package com.example.kimsm.buskingproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class UserActivity extends AppCompatActivity {
    String id;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent i = getIntent();
        id = i.getStringExtra("id");
        pass = i.getStringExtra("pass");
        DataAsync data = new DataAsync();
        data.execute();
    }

    class DataAsync extends AsyncTask<Void, String, Void> {
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Toast.makeText(UserActivity.this, values[0], Toast.LENGTH_SHORT).show();
            if(values[0]=="로그인 실패"){
                Intent j = new Intent(UserActivity.this, MainActivity.class);
                startActivity(j);
            } else if(values[0]=="로그인 성공") {
                Intent t = new Intent(UserActivity.this, SelectLocalActivity.class);
                t.putExtra("id",id);
                startActivity(t);
            }
        }

        protected Void doInBackground(Void... voids) {//user thread
            // 70.12.244.133
            String url = "http://1.233.141.140:7070/loginproject/JSP/login.jsp";
            String param = "?id=" + id + "&pass=" + pass;

            Document xml = null;
            String u = url + param;
            try {
                xml = Jsoup.connect(u).get();//url에 접속해서 xml파일을 받아옴
            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements result = xml.select("data");

            for (Element e : result) {
                if (e.select("result").text().equals("true"))
                    publishProgress("로그인 성공");
                else
                    publishProgress("로그인 실패");
            }

            return null;
        }
    }
}
