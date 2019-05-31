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
    ArrayList<String> stores = new ArrayList<String>();
    ArrayList<String> descriptions = new ArrayList<String>();
    ArrayList<String> review_number = new ArrayList<String>();
    ArrayList<String> stars = new ArrayList<String>();

    public MyAdapter(Context a, ArrayList<String> stores, ArrayList<String> descriptions, ArrayList<String> review_number, ArrayList<String> stars){
        for (int i=0; i<stores.size();i++) {
            this.stores.add(stores.get(i));
        }
        for (int i=0; i<descriptions.size();i++) {
            this.descriptions.add(descriptions.get(i));
        }
        for (int i=0; i<review_number.size();i++) {
            this.review_number.add(review_number.get(i));
        }
        for (int i=0; i<stars.size();i++) {
            this.stars.add(stars.get(i));
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

        String name = stores.get(position);
        String description = descriptions.get(position);
        String review = review_number.get(position);
        String star = stars.get(position);

        Store_Name.setText(name);
        Description.setText(description);
        Review_number.setText(review);
        Stars.setText(star);

        return show;
    }
}
