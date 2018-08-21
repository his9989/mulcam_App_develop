package com.example.student.threadproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {
    int mainvalue, threadvalue;
    TextView Main_Text;
    TextView Thread_Text;
    MyHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Main_Text = (TextView)findViewById(R.id.Main_Text);
        Thread_Text = (TextView)findViewById(R.id.Thread_Text);

        handler = new MyHandler();      // main Thread 소속의 Handler

        //Tiger / Lion 어떤 Thread로 하든 결과는 똑같다. 다른 방식을 소개한 것.

//        Tiger t = new Tiger();
//        t.setDaemon(true);      //daemon thread로 지정. main이 끝나면 같이 종료됨. 이거 없으면 프로그램 종료되도 계속 실행됨.
//        t.start();

        Lion l = new Lion();
        Thread t2 = new Thread(l);
        t2.setDaemon(true);
        t2.start();
    }

    public void process(View v){
        mainvalue++;
        Main_Text.setText("Main Value : " + mainvalue);
        Thread_Text.setText("Thread Value : " + threadvalue);
    }

    class Tiger extends Thread{
        @Override
        public void run() {             // Thread가 해야할 작업 내용을 갖고 있는 메소드.
            while(true) {
                threadvalue++;

                //Thread_Text.setText("Thread Value : " + threadvalue); // 이 작업은 화면(View)를 바꾸는 작업. 이건 mainThread만 가능하다. 이런 Thread 객체에서는 할 수 없다.

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Lion implements Runnable{
        @Override
        public void run() {             // Thread가 해야할 작업 내용을 갖고 있는 메소드.
            while(true) {
                threadvalue++;
                //Thread_Text.setText("Thread Value : " + threadvalue); // 이 작업은 화면(View)를 바꾸는 작업. 이건 mainThread만 가능하다. 이런 Thread 객체에서는 할 수 없다.

                // Handler를 이용해서 User Thread에서 화면을 편집하는 방법
                Message msg = new Message();
                handler.sendMessage(msg);   // 1방법. 내용까지 보낼 때.
                                             // main Thread에게 message를 보내는 것.
                                             // main에 도착하면 자동으로 MyHandler 메소드를 실행하게 된다.

                // handler.sendEmptyMessage(1);    //2방법. 내용 없이 신호만 보낼 때

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyHandler extends Handler {
        // 다른 thread로부터 message가 도착하면 자동으로 실행되는 메소드
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Thread_Text.setText("Thread Value : " + threadvalue);
            // 이렇게 되면, 메인 Thread에서의 onClick 메소드 여부와 무관하게 바로 UI에 User Thread에 의한 내역이 출력된다.
        }
    }
}
