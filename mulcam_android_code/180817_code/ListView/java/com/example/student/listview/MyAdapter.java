package com.example.student.listview;

// Adapter를 만드는 코드

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter implements View.OnClickListener {

    // MyAdapter를 통해 받을 변수 3개 선언
    Context context;
    int itemlayout;
    ArrayList<product> data;
    LayoutInflater inflater;    // xml 문서의 내용을 java 객체로 만들어 주는 클래스.

    //MyAdapter의 생성자.
    //inflater는 context에 해당하는 Activity의 xml 문서 내용을 java객체로 만들어준다.
    public MyAdapter(Context context, int itemlayout, ArrayList<product> data){
        this.context = context;          //어떤 Activity에 대한 내용인지.
        this.itemlayout = itemlayout;   // 한 행에 대한 xml 문서
        this.data = data;                // data
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //adapter가 ArrayList 데이터를 꺼내서 한 개의 아이템을 만들어주는 메소드
    //data 개수만큼 자동으로 한 행씩 꺼내서 보여주는 메소드
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //position : ListView에 들어갈 열의 위치
        //convertView : ListView에 들어갈 행 하나
        //parent : ListView

        if(convertView == null){
            convertView = inflater.inflate(itemlayout, parent, false);
            //화면이 하나도 그려져있지 않은 경우, 처음으로 화면을 만드는 작업
            //itemlayout : 행 하나의 데이터
            //parent : ListView
            //false 대신에 true인 경우, ListView 전체가 return 된다. 한 행씩만 만들 것이므로, false로 한다.
        }

        //position 기준으로 data를 꺼낸다.
        product p = data.get(position);
        ImageView img = (ImageView)convertView.findViewById(R.id.iv);
        TextView txt = (TextView)convertView.findViewById(R.id.tv);
        Button info = (Button)convertView.findViewById(R.id.info);
        TextView count = (TextView)convertView.findViewById(R.id.tv2);

        //onClick는 View.OnClickListener 내부의 메소드.
        info.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(context, data.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //p에서 뽑은 이미지 데이터와 txt데이터를 셋팅한다.
        img.setImageResource((p.getImageID()));
        txt.setText(p.getName());
        count.setText(p.getCount()+"");

        //행 하나씩 꺼낸다.
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }
}
