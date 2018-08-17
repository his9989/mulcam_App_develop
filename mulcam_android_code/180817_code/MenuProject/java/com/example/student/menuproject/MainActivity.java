package com.example.student.menuproject;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    ConstraintLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.b);
        background = (ConstraintLayout)findViewById(R.id.background);
        registerForContextMenu(b);
    }

    //options menu 생성. title bar 옆에 붙는 메뉴.
    // Activity에서 options menu를 사용하면 이와 같이 옵션처럼 사용할 수 있다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.myoptions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int mid = item.getItemId();
        switch (mid){
            case R.id.refresh:
                Toast.makeText(this, "새로 고침", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this, "찾기", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "설정", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //context menu 생성. Long Click 시 나타나는 메뉴
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==b) {
            menu.setHeaderTitle("Context Menu Title");
            menu.add(0, 1, 0, "Red");
            menu.add(0, 2, 0, "Blue");
            menu.add(0, 3, 0, "Green");
            menu.add(0, 4, 0,"Origin");
        }
    }

    //context menu 선택시 실행될 이벤트 처리 메소드
    //menu는 Red, Blue, Green을 모두 갖는 큰 개념
    //Menu 중 하나가 item으로서 인자에 전달된다.
    // onCreateContextMenu와 onContextItemSelected는 셋트다.
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int code = item.getItemId();
        switch (code){
            case 1:
                b.setTextColor(Color.RED);
                background.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                b.setTextColor(Color.BLUE);
                background.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                b.setTextColor(Color.GREEN);
                background.setBackgroundColor(Color.RED);
                break;
            case 4:
                b.setTextColor(Color.BLACK);
                background.setBackgroundColor(Color.WHITE);
        }
        return super.onContextItemSelected(item);
    }

}
