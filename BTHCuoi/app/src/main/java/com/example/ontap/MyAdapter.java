package com.example.ontap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

public class MyAdapter implements Adapter {
    LayoutInflater inflater;
    ListView listView;
    Context context;
    public MyAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return MainActivity.sanPhamList.size();
    }

    @Override
    public Object getItem(int i) {
        return MainActivity.sanPhamList;
    }

    @Override
    public long getItemId(int i) {
        return MainActivity.sanPhamList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.activity_main, null);

        return rowView;
    }
}
