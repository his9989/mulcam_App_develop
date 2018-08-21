package com.example.student.preferencesproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.result);
    }

    public void process(View v){
        int id = v.getId();
        switch (id) {
            case R.id.put:
                SharedPreferences pref =
                        getSharedPreferences("preftest", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("num", "111");
                editor.putString("name", "hill kollins");
                editor.putString("address", "seatile");
                editor.apply(); // commit 역할
                break;
            case R.id.get:
                SharedPreferences pref2 =
                        getSharedPreferences("preftest", MODE_PRIVATE); // mode:0 과 MODE_PRIVATE는 같은 말
//                String num = pref2.getString("num", "");
//                String name = pref2.getString("name", "");
//                String address = pref2.getString("address", "");

                String val = "";
                Map<String, ?> map = pref2.getAll();
                Set<String> keys = map.keySet();    // keys = name, num, address를 모아놓은 주머니
                for(String key : keys){
                    val += key+":"+map.get(key)+"\n";
                }

//                result.setText(num+":"+name+":"+address);
                result.setText(val);
                break;
        }
    }
}
