package com.example.student.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
//Event 처리 : 1. Listener 선언
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> cities;
    EditText newcity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI
        listView = (ListView)findViewById(R.id.listview);
        newcity = (EditText)findViewById(R.id.newcity);

        //DATA
        cities = new ArrayList<>();

        cities.add("seoul");
        cities.add("pusan");
        cities.add("la");
        cities.add("tokyo");
        cities.add("seattle");
        cities.add("washington");
        cities.add("sydney");
        cities.add("osaka");
        cities.add("ohio");
        cities.add("kkyoto");
        cities.add("cheju");
        cities.add("moscow");
        cities.add("singapore");

        //Adapter(UI, DATA)
        adapter = new ArrayAdapter<>(
                this,
                //android.R.layout.simple_list_item_1,    // ListView의 item(하나의 행)에 사용할 data가 어떻게 생겼는지 알려주는 Layout xml
                                                           // 앞의 android.이 붙어 있는건, 안드로이드가 이미 만들어둔 화면 설계
                                                           // 즉, R.id.- : 우리가 만든거
                                                           // android.R.id.- : 이미 만들어져 있는거
                android.R.layout.simple_list_item_single_choice, //선택 기능 추가. single 대신 multi하면 다중 선택도 가능하다.
                android.R.id.text1,                       // 하나의 행 안에서 어디에 뿌릴지의 정보. (위, 아래 등 UI적 데이터)
                cities
        );

        //Adapter
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //사건이 발생하는 대상에게 리스너 등록
        listView.setOnItemClickListener(this);
    }

    //사건이 발생했을 때, Listener가 실행하는 사건 처리 메소드
    @Override
    //Call Back Service의 한 종류
    public void onItemClick(AdapterView<?> listview, View view, int position, long id) {
        // 밑의 2개의 코드는 같은 역할
        String city = cities.get(position);
        //String city = listview.getItemAtPosition(position);

        Toast.makeText(this, "city : "+city, Toast.LENGTH_SHORT).show();

        //intent 생성한 후에 city를 intent에 저장
        //setResult(1, i);
        //돌아가기 finish()
        Intent i = new Intent();
        i.putExtra("city", city);
        setResult(1, i);
        finish();
    }

    public void process(View v){
        int id = v.getId();
        switch(id){
            case R.id.add:
                String value = newcity.getText().toString();
                cities.add(0, value);
                adapter.notifyDataSetChanged();
                newcity.setText("");
                break;
            case R.id.del:
                int index = listView.getCheckedItemPosition();
                cities.remove(index);
                adapter.notifyDataSetChanged();
                listView.clearChoices();
                break;
        }
    }
}
