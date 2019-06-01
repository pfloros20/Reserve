package com.example.reserve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyThirdAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    ArrayList<Integer> table_id = new ArrayList<Integer>();;
    ArrayList<Integer>   capacity = new ArrayList<Integer>();;
    ArrayList<String>   availability = new ArrayList<String>();;


    public MyThirdAdapter(Context a, ArrayList<Integer> table_id, ArrayList<Integer> capacity, ArrayList<String>   availability){
        for (int i=0; i<table_id.size();i++) {
            this.table_id.add(table_id.get(i));
        }
        for (int i=0; i<capacity.size();i++) {
            this.capacity.add(capacity.get(i));
        }
        for (int i=0; i<availability.size();i++) {
            this.availability.add(availability.get(i));
        }
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return table_id.size();
    }

    @Override
    public Object getItem(int position) {
        return table_id.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View show = mInflater.inflate(R.layout.tablecustomlist,null);
        TextView tableID = (TextView)show.findViewById(R.id.TableID);
        TextView table_capacity = (TextView)show.findViewById(R.id.Table_Capacity);
        TextView table_availability = (TextView)show.findViewById(R.id.Availability);

        String t_id = String.valueOf(table_id.get(position));
        String t_cap = String.valueOf(capacity.get(position));
        String t_avail = availability.get(position);


        tableID.setText("Table:"+t_id);
        table_capacity.setText("Capacity:"+t_cap);
        table_availability.setText("Status:"+t_avail);

        return show;
    }
}
