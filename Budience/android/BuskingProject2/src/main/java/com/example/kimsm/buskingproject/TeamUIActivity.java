package com.example.kimsm.buskingproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;

public class TeamUIActivity extends YouTubeBaseActivity {

    String teamname;
    TextView team;
    TextView local1;
    TextView members1;
    TextView jarne1;
    TextView intro1;
    TextView youtube1;
    TextView record11;
    TextView record21;
    TextView record31;
    TextView record41;

    YouTubePlayerView youTubeView;
    Button button;
    YouTubePlayer.OnInitializedListener listener;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_ui);
        Intent i = getIntent();
        teamname = i.getStringExtra("id");

        team = (TextView)findViewById(R.id.teamname);
        local1 = (TextView)findViewById(R.id.local);
        members1 = (TextView)findViewById(R.id.members);
        jarne1 = (TextView)findViewById(R.id.jarne);
        intro1 = (TextView)findViewById(R.id.intro);
        youtube1 = (TextView)findViewById(R.id.youtube);
        record11 = (TextView)findViewById(R.id.record1);
        record21 = (TextView)findViewById(R.id.record2);
        record31 = (TextView)findViewById(R.id.record3);
        record41 = (TextView)findViewById(R.id.record4);

        button=(Button)findViewById(R.id.youtubebutton);
        youTubeView = (YouTubePlayerView)findViewById(R.id.view);

        DataAsync data = new DataAsync();
        data.execute();

    }

    class DataAsync extends AsyncTask<Void, String, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            String url = "http://1.233.141.140:7070/team_data/JSP/TeamData.jsp";
            String param = "?teamname=" + teamname;

            Document xml = null;
            String u = url + param;
            try {
                xml = Jsoup.connect(u).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements data = xml.select("data");

            for(Element e:data) {
                String name = e.select("TEAMNAME").text();
                String local = e.select("LOCAL").text();
                String record2 = e.select("RECORD2").text();
                String record1 = e.select("RECORD1").text();
                String members = e.select("MEMBERS").text();
                String jarne = e.select("JARNE").text();
                String intro = e.select("INTRO").text();
                String youtube = e.select("YOUTUBE").text();
                String record3 = e.select("RECORD3").text();
                String record4 = e.select("RECORD4").text();
                team.setText(name);
                local1.setText(record2);
                record11.setText(youtube);
                record21.setText(record3);
                members1.setText(local);
                jarne1.setText(record1);
                intro1.setText(members);
                youtube1.setText(jarne);
                record31.setText(record4);
                record41.setText(record4);
            }

            publishProgress();

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            listener = new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.loadVideo(youtube1.getText().toString());
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(check==false) {
                        youTubeView.setVisibility(View.VISIBLE);
                        youTubeView.initialize("AIzaSyCoHgjMwVmRCS5e8TqCMeu6qqZGIYMuFyQ", listener);
                        button.setText("Stop");
                        check=true;
                    }
                    else if(check==true){
                        youTubeView.setVisibility(View.INVISIBLE);
                        Intent t = new Intent(TeamUIActivity.this, TeamUIActivity.class);
                        t.putExtra("teamname",teamname);
                        startActivity(t);
                    }
                }
            });
        }
    }
}
