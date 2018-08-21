package com.example.student.sqlliteproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView result;
    SQLiteDatabase db;      // SQLiteDatabse 타입의 객체, Insert, Select, Delete 등 DB에서 하는 메소드 사용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.result);
    }

    // DB 생성
    // member.db가 파일 이름
    // 기존에 파일 이름이 있는 경우 open하고, 없으면 Create하는 명령어
    //
    public void createDB(View view) {
        db = openOrCreateDatabase("member.db", Context.MODE_PRIVATE, null);
    }

    public void createTable(View view) {
        String q = "create table if not exists member(_id text primary key, " + "name text, address text)";
        db.execSQL(q);
        Log.i("sqllite::::", "table creation success");
    }

    public void insertData(View view) {
        String q = "insert into member values(100, 'tommy', 'seoul')";
        db.execSQL(q);

        q = "insert into member values(200, 'Harry', 'LA')";
        db.execSQL(q);

        q = "insert into member values(300, 'Jenny', 'Singapore')";
        db.execSQL(q);
    }

    public void selectData(View view) {
        String q = "select * from member";
        // 결과를 받아오기 위한 rawQuery.
        // cursor는 database의 제목을 가리키는 포인터 같은 개념념
        // cursor는 이 프로젝트에서 DB에 접근하여 데이터를 가지고 오기 이한 뽑기 도구 같은 느낌.

        Cursor cursor = db.rawQuery(q, null);
        String msg = "";

        if(cursor != null){
            // moveNext를 통해 제목을 가리키던 cursor가 data를 가리키기 시작.
            while(cursor.moveToNext()){

                //Index=0인 data를 int 타입으로 뽑아서 num이라는 변수로 받겠다.
                int num = cursor.getInt(0);

                //index=1인 data를 String 타입으로 뽑아서 String이라는 변수로 받겠다.
                String name = cursor.getString(1);

                //Index=2인 data를 String 타입으로 뽑아서 String이라는 변수로 받겠다.
                String address = cursor.getString(2);

                msg += num+", "+name+", "+address+"\n";
            }
            result.setText(msg);
        }
    }
}
