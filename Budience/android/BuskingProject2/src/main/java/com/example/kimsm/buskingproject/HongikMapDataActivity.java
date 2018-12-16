package com.example.kimsm.buskingproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class HongikMapDataActivity extends AppCompatActivity {

    ArrayList<String> teamname;
    ArrayList<String> locx;
    ArrayList<String> locy;
    ArrayList<String> startti;
    ArrayList<String> info;
    ArrayList<String> endti;
    ArrayList<String> genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hongik_map_data);


        teamname = new ArrayList<>();
        locx = new ArrayList<>();
        locy = new ArrayList<>();
        startti = new ArrayList<>();
        endti = new ArrayList<>();
        genre = new ArrayList<>();

        info = new ArrayList<>();
        DataAsync data = new DataAsync();
        data.execute();

    }

    class DataAsync extends AsyncTask<Void, String, Void> {
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Intent i = new Intent(HongikMapDataActivity.this,HongikMapActivity.class);
            i.putStringArrayListExtra("locx",locx);
            i.putStringArrayListExtra("locy",locy);
            i.putStringArrayListExtra("startti",startti);
            i.putStringArrayListExtra("endti",endti);
            i.putStringArrayListExtra("teamname",teamname);
            i.putStringArrayListExtra("info",info);
            i.putStringArrayListExtra("genre",genre);
            startActivity(i);
        }

        protected Void doInBackground(Void... voids) {//user thread
            String url = "http://1.233.141.140:7070/team_data/JSP/mapinfo.jsp";
            Document xml = null;
            try {
                xml = Jsoup.connect(url).get();//url에 접속해서 xml파일을 받아옴
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements result = xml.select("data");
            int i=0;
            for (Element e : result) {
                teamname.add(e.select("TEAMNAME").text().toString());
                locx.add(e.select("LOCX").text().toString());
                locy.add(e.select("LOCY").text().toString());
                startti.add(e.select("STARTTIME").text().toString());
                endti.add(e.select("ENDTIME").text().toString());
                info.add(e.select("INTRO").text().toString());
                genre.add(e.select("GENRE").text().toString());

            }
            Log.i("zzzzzzz:",locx.get(1)+locy.get(1));
            publishProgress();
            return null;
        }
    }
}
