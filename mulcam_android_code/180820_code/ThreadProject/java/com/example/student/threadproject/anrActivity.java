package com.example.student.threadproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class anrActivity extends AppCompatActivity {

    TextView value;
    int count;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr);

        value = (TextView)findViewById(R.id.value);
    }

    public void process(View v){
        UploadAsync upload = new UploadAsync();
        if(v.getId() == R.id.increase) {
            count++;
            value.setText("value:" + count);
        } else {
            if(flag == true){
                Toast.makeText(anrActivity.this, "업로드 중 입니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class UploadAsync extends  AsyncTask <Integer, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(anrActivity.this, "업로드를 시작합니다.", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Toast.makeText(anrActivity.this, "업로드 중 입니다.", Toast.LENGTH_SHORT).show();
            flag = false;
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            flag = true;
            upload();
            publishProgress(100);
            return 100;
        }
    }

    public void upload(){
        for(int i=0; i<100; i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
