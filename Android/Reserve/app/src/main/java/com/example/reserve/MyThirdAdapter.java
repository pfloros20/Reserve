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
    ArrayList<Table> tables = new ArrayList<Table>();


    public MyThirdAdapter(Context a, ArrayList<Table> tables){
        for (int i=0; i<tables.size();i++) {
            this.tables.add(tables.get(i));
        }
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tables.size();
    }

    @Override
    public Object getItem(int position) {
        return tables.get(position);
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

        String t_id = String.valueOf(tables.get(position).ID);
        String t_cap = String.valueOf(tables.get(position).Capacity);
        String t_avail = tables.get(position).Availability;


        tableID.setText("Table:"+t_id);
        table_capacity.setText("Capacity:"+t_cap);
        table_availability.setText("Status:"+t_avail);

        return show;
    }
}
