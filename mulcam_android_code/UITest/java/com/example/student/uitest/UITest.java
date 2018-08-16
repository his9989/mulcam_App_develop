package com.example.student.uitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class MyClick implements View.OnClickListener{

    @Override
    public void onClick(View v) {
        Log.e("UITEST", "Click...");
    }
}

public class UITest extends AppCompatActivity /*implements View.OnClickListener*/{
    private TextView tv;
    private EditText et;
    private Button bt;

    /* 2번째 방법
    private class MyClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String s = et.getText().toString();
            tv.setText(s);
            et.setText("");        }
    } */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uitest);
        et = findViewById(R.id.first_edit);
        tv = findViewById(R.id.first_tv);

//        bt = findViewById(R.id.first_button);
//        // MyClick click = new MyClick();
//
//
//        // View.OnClickListener click ;
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String s = et.getText().toString();
//                tv.setText(s);
//                et.setText("");
//            }
//        });    // this : UITest인데, OnClickListner으로 UpCasting 된다.

        findViewById(R.id.first_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et.getText().toString();
                tv.setText(s);
                et.setText("");
            }
        });


        // 처음에 배웠던 Event 생성 방법
//        LinearLayout linear = findViewById(R.id.linear);
//
//        linear.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });

        // Event 쉽게 생성하는 방법
        findViewById(R.id.linear).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Toast t = Toast.makeText(UITest.this, "x : " + event.getX()+", y : " + event.getY(), Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.LEFT|Gravity.TOP,(int)event.getX(), (int)event.getY());
                        t.show();
                        break;
                    case MotionEvent.ACTION_MOVE:

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                }
                return false;
            }
        });

        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        Toast.makeText(UITest.this, et.getText(), Toast.LENGTH_SHORT).show();
                        //this : KeyListener
                        //우리가 필요한건, UITest가 받는 AppCompatActivity의 Context를 받고자하므로, UITest.this라 한다.
                        return true;
                    }
                }
                return false;
                //false인 경우, Enter 입력 시 본래 Enter의 Event인 개행을 실시한다.
                //true인 경우, Enter 입력 시 본래 Enter의 개행을 실시하지 않는다.
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String s = et.getText().toString();
        // testview를 edit에 입력된 string으로 바꾼다.
        tv.setText(s);

        // testview를 아래의 String으로 고친다.
        // tv.setText("Hello java and Android");
    }


    /* 1번째 방법
    @Override
    public void onClick(View v) {
        String s = et.getText().toString();
        tv.setText(s);
        et.setText("");
    }
    */
}
