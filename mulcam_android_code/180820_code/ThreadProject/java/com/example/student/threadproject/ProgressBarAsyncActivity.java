package com.example.student.threadproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarAsyncActivity extends AppCompatActivity {
    // ProgressBar : 로딩 바 같은 것.

    TextView tv;
    ProgressBar bar;
    ProgressAync async;
    int value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_async);

        tv = (TextView)findViewById(R.id.TextView);
        bar = (ProgressBar)findViewById(R.id.progressBar);
    }

    class ProgressAync extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected void onPreExecute() { // main에 의해 실행되는 곳.
            super.onPreExecute();
            bar.setProgress(value); // progressBar에
        }

        // Thread가 모두 종료되고 main Thread에 의해 호출되는 메소드
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            bar.setProgress(0);
            tv.setText("finish...");
            Toast.makeText(ProgressBarAsyncActivity.this, "finish!", Toast.LENGTH_SHORT).show();
            value=0;
        }

        // values -> 배열 원소로 value값을 받는다.
        // 퍼센트를 나타내는 value값이 values[0]에 저장된다.
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            bar.setProgress(values[0]);
            tv.setText("Current value : " + values[0]); // textview 텍스트를 수정한다.
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            bar.setProgress(0);
            tv.setText("canceld...");
            Toast.makeText(ProgressBarAsyncActivity.this, "cancled...", Toast.LENGTH_SHORT).show();
            value=0;
        }

        //Integers : Integer타입의 배열
        // doInBackground만 user Thread
        @Override
        protected Integer doInBackground(Integer... integers) {
            while(isCancelled()==false){    // cancel button이 눌리지 않은 경우,
                value++;

                if(value>100){
                    break;
                } else{
                    publishProgress(value); // 화면 업데이트. 여기의 value가 onProgressUpdate의 인자로 들어감.
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
    public void process(View v){
        if(v.getId() == R.id.run){ // 실행
             async = new ProgressAync();
             async.execute(100);
        }else { // 취소
            async.cancel(true);
        }
    }
}
