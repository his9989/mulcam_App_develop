package com.example.kimsm.buskingproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listviewItems = new ArrayList<ListViewItem>();

    public ListViewAdapter(){


    }
    @Override
    public int getCount() {
        return listviewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listviewItems.get(position) ;

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView;
        iconImageView = (ImageView) convertView.findViewById(R.id.imageView2);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listviewItems.get(position);
        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTime());
        descTextView.setText(listViewItem.getExplain());

        return convertView;

    }

    public void addItem(Drawable icon, String time, String explain ){
        ListViewItem item = new ListViewItem();

        item.setExplain(explain);
        item.setIcon(icon);
        item.setTime(time);

        listviewItems.add(item);
    }
}