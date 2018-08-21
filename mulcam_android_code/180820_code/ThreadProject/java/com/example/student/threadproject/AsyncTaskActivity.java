package com.example.student.threadproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity {
    int mainvalue, threadvalue;
    TextView Main_Text;
    TextView Thread_Text;
    int max = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Main_Text = (TextView)findViewById(R.id.Main_Text);
        Thread_Text = (TextView)findViewById(R.id.Thread_Text);

        // Thread를 만드는 대신에, 다음 2 코드에서 new MyAsyncTask();를 통해 자동으로 Thread를 만들고 작업 시작을 할 수 있게 된다.
        // MyAsyncTask 자식 객체를 만들어서 사용해도 된다.
        MyAsyncTask task = new MyAsyncTask();
        task.execute(111,222,333);
    }

    public void process(View v){
        mainvalue++;
        Main_Text.setText("Main Value : " + mainvalue);
    }

    // AsyncTask: 객체 안의 main thread, user thread가 해야할 메소드를 모두 가지고 있다.
    // <>안의 자료형은 Thread가 하는 일, Thread가 main에게 전달하는 값과 관련이 있다.
    class MyAsyncTask extends AsyncTask<Integer, Integer, Integer> {

        // main Thread가 실행하는 메소드.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Thread가 작업을 시작하기 전에 준비작업.
            // 1st로 실행되는 메소드.
        }

        // main Thread가 실행하는 메소드.
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            // 4th 실행되는 메소드.
        }

        // main Thread가 실행하는 메소드.
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Thread_Text.setText("thread values : " + values[0]);
            // 3rd 실행되는 메소드.
        }

        // 사용자 정의 Thread(User Thread)가 실행하는 메소드.
        // 가장 중요한 부분
        @Override
        protected Integer doInBackground(Integer... strings) {
            while(threadvalue < max) {
                threadvalue++;
                publishProgress(threadvalue, 100, 220);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
            // 2nd로 실행되는 메소드.
        }
    }
}
