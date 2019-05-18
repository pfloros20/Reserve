package com.example.reserve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] stores;
    String[] descriptions;
    String[]   review_number;
    String[]   stars;

    public MyAdapter(Context a, String[] stores, String[] descriptions, String[] review_number, String[] stars){
        this.stores = stores;
        this.descriptions = descriptions;
        this.review_number = review_number;
        this.stars = stars;
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return stores.length;
    }

    @Override
    public Object getItem(int position) {
        return stores[position];
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

        String name = stores[position];
        String description = descriptions[position];
        String review = review_number[position];
        String star = stars[position];

        Store_Name.setText(name);
        Description.setText(description);
        Review_number.setText(review);
        Stars.setText(star);

        return show;
    }
}
