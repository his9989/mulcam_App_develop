package com.example.student.sqlliteproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView list;
    SQLiteDatabase db;      // SQLiteDatabse 타입의 객체, Insert, Select, Delete 등 DB에서 하는 메소드 사용
    ArrayList<String> data;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView)findViewById(R.id.list);
        data = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, //선택 기능 추가. single 대신 multi하면 다중 선택도 가능하다.
                android.R.id.text1,                       // 하나의 행 안에서 어디에 뿌릴지의 정보. (위, 아래 등 UI적 데이터)
                data
        );

        //Adapter
        list.setAdapter(adapter);


    }

    protected void onStart(){
        super.onStart();
        createDB();
        createTable();
        selectData();
    }

    // DB 생성
    // member.db가 파일 이름
    // 기존에 파일 이름이 있는 경우 open하고, 없으면 Create하는 명령어
    //
    public void createDB() {
        db = openOrCreateDatabase("member.db", Context.MODE_PRIVATE, null);
    }

    public void createTable() {
        // id, name, address가 database table이름
        // Primary Key 설정
        String q = "create table if not exists member(_id text primary key, " + "name text, address text)";
        db.execSQL(q);
        Log.i("sqllite::::", "table creation success");
    }

    // 상단에 나타나는 메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, 0, "Add Date");
        return super.onCreateOptionsMenu(menu);
    }

    // 상단의 메뉴를 클릭했을 때 발생할 이벤트
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this, InsertActivity.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }

    public void insertData() {
        String q = "insert into member values(400, 'tommy', 'seoul')";
        db.execSQL(q);

        q = "insert into member values(500, 'Harry', 'LA')";
        db.execSQL(q);

        q = "insert into member values(600, 'Jenny', 'Singapore')";
        db.execSQL(q);
    }

    public void selectData() {
        String q = "select * from member order by _id";

        data.clear();
        // 결과를 받아오기 위한 rawQuery.
        // cursor는 database의 제목을 가리키는 포인터 같은 개념념
        // cursor는 이 프로젝트에서 DB에 접근하여 데이터를 가지고 오기 이한 뽑기 도구 같은 느낌.

        Cursor cursor = db.rawQuery(q, null);
        String msg = "";

        //Cursor가 잘 가리키고 있다면!
        if(cursor != null){
            // moveNext를 통해 제목을 가리키던 cursor가 data를 가리키기 시작.
            while(cursor.moveToNext()){

                //Index=0인 data를 int 타입으로 뽑아서 num이라는 변수로 받겠다.
                String num = cursor.getString(0);

                //index=1인 data를 String 타입으로 뽑아서 String이라는 변수로 받겠다.
                String name = cursor.getString(1);

                //Index=2인 data를 String 타입으로 뽑아서 String이라는 변수로 받겠다.
                String address = cursor.getString(2);

                data.add(num+", "+name+", "+address+"\n");
            }
            adapter.notifyDataSetChanged();
        }
        db.close();
    }
}
