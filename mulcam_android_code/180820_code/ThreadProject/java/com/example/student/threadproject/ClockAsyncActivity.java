package com.example.student.threadproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

public class ClockAsyncActivity extends AppCompatActivity {
    TextView clockText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clockText = (TextView)findViewById(R.id.Thread_Text);

        ClockAsync async = new ClockAsync();
        async.execute();
    }

    class ClockAsync extends AsyncTask<Void, Void, Void>{

        // main Thread
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

            clockText.setText("Current Time : " + new Date());
        }

        // user Thread.
        @Override
        protected Void doInBackground(Void... voids) {
            // Main Thread는 현재 시간을 출력하는 역할
            // User Thread의 publichProgress()는 Main Thread를 부르는 역할이다.
            // 즉, 1초마다 Main Thread를 불러서, 시간이 가는 것 처럼 보이게 한다.
            while(true) {
                publishProgress();                      // ClockAsync 즉, Main Thread를 호출하는 명령어.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            return null;
        }
    }
}
