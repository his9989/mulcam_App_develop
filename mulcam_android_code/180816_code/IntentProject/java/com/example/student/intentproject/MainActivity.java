package com.example.student.intentproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //event 처리 메소드. v: 사건이 발생한 대상
    public void sub(View v){
        Intent i = new Intent(this, SubActivity.class);
        startActivity(i);
    }

    // 명시적 intent
    public void data(View v){
        Intent i = new Intent(this, DataActivity.class);
        i.putExtra("code", "android");
        i.putExtra("count", 999);
        //startActivity(i); : i라는 intent를 실행한다.
        startActivityForResult(i, 100); // i라는 intent를 실행하고, 100에 해당하는 Code를 request한다.
                                                     // 즉, 그냥 start하는게 아니라, 해당 Activity로 갔다가 돌아올 때 무슨 값을 받을 것이라는 의미
    }

    // 결과 처리 메소드


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 ) { // DataActivity에서 돌아옴.
                                  // 즉, 위에서 startActivityForResult(i, 100); 실행시 이 코드가 실행된다.
            if(resultCode == 1){ // 정상종료
                String result = data.getStringExtra("result");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            } else {            // 비정상 정료

            }
        } else{

        }
    }

    // 암시적 intent
    public void process(View v){
        int id = v.getId();
        if(id==R.id.call){
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("tel:010-1111-2222"));
            startActivity(i);
        } else{
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://m.naver.com"));
            startActivity(i);
        }
    }
}
