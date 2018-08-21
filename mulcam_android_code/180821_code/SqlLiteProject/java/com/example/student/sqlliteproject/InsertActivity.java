package com.example.student.sqlliteproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    EditText userid;
    EditText username;
    EditText useraddress;

    SQLiteDatabase db;

    public void createDB(){
        db = openOrCreateDatabase("member.db", Context.MODE_PRIVATE, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        userid = (EditText)findViewById(R.id.userid);
        username = (EditText)findViewById(R.id.username);
        useraddress = (EditText)findViewById(R.id.useraddress);

        createDB();
    }

    public void insert(View v){
        String uid = userid.getText().toString();
        String uname = username.getText().toString();
        String uaddress = useraddress.getText().toString();

        // 내부에 값을 저장할 수 있는 객체
        // val.put 명령어를 이용해서
        ContentValues val = new ContentValues();

        val.put("id", uid);
        val.put("name", uname);
        val.put("address", uaddress);

        // 위의 put은 아래 코드의 3번째 인자로 사용된다.
        db.insert("member", null, val);

        userid.setText("");
        username.setText("");
        useraddress.setText("");

        // 이전에 intent로 자신을 불렀던 화면으로 돌아감
        finish();
    }
}
