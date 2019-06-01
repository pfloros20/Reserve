package com.example.reserve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    ArrayList<Store> stores = new ArrayList<Store>();

    public MyAdapter(Context a, ArrayList<Store> stores){
        for (int i=0; i<stores.size();i++) {
            this.stores.add(stores.get(i));
        }
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return stores.size();
    }

    @Override
    public Object getItem(int position) {
        return stores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View show = mInflater.inflate(R.layout.customlist,null);
        TextView Store_Name = (TextView)show.findViewById(R.id.Store_Name);
        TextView Description = (TextView)show.findViewById(R.id.Description);
        TextView Review_number = (TextView)show.findViewById(R.id.Review_number);
        TextView Stars = (TextView) show.findViewById(R.id.Stars);

        String name = stores.get(position).Name;
        String description = stores.get(position).Description;
        String review = String.valueOf(stores.get(position).Reviews.size());
        String star = stores.get(position).Stars;

        Store_Name.setText(name);
        Description.setText(description);
        Review_number.setText(review);
        Stars.setText(star);

        return show;
    }
}
