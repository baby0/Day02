package com.example.lenovo.my_app.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.my_app.ThreeActivity;

import java.util.List;

/**
 * Created by lenovo on 2017/12/12.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    List<String> list;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText(list.get(position));
        tv.setTextSize(20);
        return tv;
    }
}

