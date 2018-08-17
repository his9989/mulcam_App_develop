package com.example.student.listview;

// 화면을 구성하는 main 역할
// activity_custom_list_view.xml로부터 UI 화면 설계를 받아온다.
// product라는 class의 객체를 만들어서 listView에 저장하고 싶은 데이터 행을 만든다. (여기서 데이터가 만들어진다.)
// activity_custom_list_view.xml로부터 받은 UI 디자인을 CLIST라는 이름으로,
// product를 이용해서 만든 데이터 객체를 plist라는 이름으로 저장한 뒤,
// Myadapter라는 어댑터를 만들어서, 전체적인 관리를 한다.


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    ArrayList<product> plist;   // data
    ListView CLIST;             // UI
    MyAdapter adapter;         //  adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        CLIST = (ListView) findViewById(R.id.CLIST);

        plist = new ArrayList<>();
        //1. data 준비
        product p1 = new product(R.mipmap.gals, "갤럭시9", 28);
        product p2 = new product(R.mipmap.ipad, "아이패드", 30);
        product p3 = new product(R.mipmap.trom, "세탁기", 10);

        plist.add(p1);
        plist.add(p2);
        plist.add(p3);

        //2. adapter
        adapter = new MyAdapter(
          this,                 // 현재 Activity
          R.layout.listitem,    // ListView 안에 들어가는 item을 위한 xml 문서
          plist                 // data가 들어있는 Arraylist
        );

        //3. ListView에 adapter 지원
        CLIST.setAdapter(adapter);
    }
}
