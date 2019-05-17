package com.example.reserve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    String[] stores;
    String[] descriptions;
    int[] review_number;
    float[] stars;
    LayoutInflater mInflator;

    public MyAdapter(Context a, String[] stores, String[] descriptions, int[] review_number, float[] stars){
        this.stores = stores;
        this.descriptions = descriptions;
        this.review_number = review_number;
        this.stars = stars;
        mInflator = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return stores.length;
    }
    @Override
    public Object getItem(int i) {
        return stores[i];
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View show = mInflator.inflate(R.layout.customlist,null);
        TextView Store_Name = (TextView) show.findViewById(R.id.Store_Name);
        TextView Description = (TextView) show.findViewById(R.id.Description);
        TextView Review_Number = (TextView) show.findViewById(R.id.Review_Number);
        RatingBar Stars = (RatingBar)show.findViewById(R.id.Stars);

        Store_Name.setText(stores[i]);
        Description.setText(descriptions[i]);
        Review_Number.setText(review_number[i]);
        Stars.setRating(stars[i]);

        return show;
    }

}
