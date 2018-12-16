package com.example.kimsm.buskingproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class HongikGridActivity extends AppCompatActivity {

    String id;

    Activity act = this;

    GridView gridView;

    String[] name_arr = null;
    String[] garne_arr = null;
    String[] local_arr = null;
    String[] teamname_arr = null;

    int count=0;

    ArrayList<Bitmap> picArr = new ArrayList<Bitmap>();
    ArrayList <String> textArr1 = new ArrayList<>();
    ArrayList <String> textArr2 = new ArrayList<>();
    ArrayList <String> textArr3 = new ArrayList<>();
    ArrayList <String> textArr4 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hongik_grid);
        Intent i = getIntent();
        id = i.getStringExtra("id");

        name_arr = new String[10];
        garne_arr = new String[10];
        local_arr = new String[10];
        teamname_arr = new String[10];

        DataAsync data = new DataAsync();
        data.execute();
    }

    public void go_Map(View view) {
        // 일단, id를 intent에 넣어야하는지 모르겠어서 안 넣음.
        Intent i = new Intent(HongikGridActivity.this, HongikMapDataActivity.class);
        startActivity(i);
    }

    public void go_List(View view) {
        // 일단, id를 intent에 넣어야하는지 모르겠어서 안 넣음.
        Intent i = new Intent(HongikGridActivity.this, HongikListActivity.class);
        startActivity(i);
    }


    public class gridAdapter extends BaseAdapter {

        LayoutInflater inflater;

        public gridAdapter() {
            inflater = (LayoutInflater)act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return picArr.size();
        }

        @Override
        public Object getItem(int position) {
            return picArr.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if(convertView==null) {
                convertView = inflater.inflate(R.layout.custom, parent, false);
            }

            ImageView imageView = (ImageView)convertView.findViewById(R.id.artistimage);
            TextView textView1 = (TextView)convertView.findViewById(R.id.textname);
            TextView textView2 = (TextView)convertView.findViewById(R.id.textjarne);
            TextView textView3 = (TextView)convertView.findViewById(R.id.textlocal);

            imageView.setImageBitmap(picArr.get(position));
            textView1.setText(textArr1.get(position));
            textView2.setText(textArr2.get(position));
            textView3.setText(textArr3.get(position));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent j = new Intent(HongikGridActivity.this, TeamUIActivity.class);
                    j.putExtra("id",textArr4.get(position));
                    startActivity(j);
                }
            });
            return convertView;
        }
    }

    class DataAsync extends AsyncTask<Void, String, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d("doin not problem","DebugMessage");
            String url = "http://1.233.141.140:7070/team_data/JSP/TeamGrid.jsp";
            Log.d("url not problem","DebugMessage");
            Document xml = null;
            try {
                xml = Jsoup.connect(url).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("Jsoup not problem","DebugMessage");

            Elements data = xml.select("team");
            Log.d("data not problem","DebugMessage");

            for(Element e:data) {
                String name = e.select("name").text();
                Log.d(name, "DebugMessage");
                name_arr[count] = name;
                String jarne = e.select("jarne").text();
                Log.d(jarne, "DebugMessage");
                garne_arr[count] = jarne;
                String local = e.select("local").text();
                Log.d(local, "DebugMessage");
                local_arr[count] = local;
                String teamname = e.select("Teamname").text();
                teamname_arr[count] = teamname;
                count++;
            }

            publishProgress();
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Bitmap bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.hyukoband);
            Bitmap bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.beenzino);
            Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.bigbang);
            Bitmap bm4 = BitmapFactory.decodeResource(getResources(), R.drawable.gdragon);
            Bitmap bm5 = BitmapFactory.decodeResource(getResources(), R.drawable.hyoshinpark);
            Bitmap bm6 = BitmapFactory.decodeResource(getResources(), R.drawable.magic);
            Bitmap bm7 = BitmapFactory.decodeResource(getResources(), R.drawable.neighbourhood);
            Bitmap bm8 = BitmapFactory.decodeResource(getResources(), R.drawable.nell);
            Bitmap bm9 = BitmapFactory.decodeResource(getResources(), R.drawable.hyukoband2);
            Bitmap bm10 = BitmapFactory.decodeResource(getResources(), R.drawable.thexx);

            picArr.add(bm1);
            picArr.add(bm2);
            picArr.add(bm3);
            picArr.add(bm4);
            picArr.add(bm5);
            picArr.add(bm6);
            picArr.add(bm7);
            picArr.add(bm8);
            picArr.add(bm9);
            picArr.add(bm10);

            Log.d("Pic not problem","DebugMessage");
            for(int i = 0; i<10; i++){
                Log.d("start for not problem","DebugMessage");
                textArr1.add(name_arr[i]);
                textArr2.add(garne_arr[i]);
                textArr3.add(local_arr[i]);
                textArr4.add(teamname_arr[i]);
            }
            Log.d("textArr not problem","DebugMessage");
            gridView = (GridView)findViewById(R.id.gridView);
            gridView.setAdapter(new gridAdapter());
        }
    }
}
