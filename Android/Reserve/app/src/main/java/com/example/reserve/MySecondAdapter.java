package com.example.reserve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MySecondAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[]   user_name;
    String[]   review;


    public MySecondAdapter(Context a, String[] user_name, String[] review){
        this.user_name = user_name;
        this.review = review;
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return user_name.length;
    }

    @Override
    public Object getItem(int position) {
        return user_name[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View show = mInflater.inflate(R.layout.reviewcustomlist,null);
        TextView User_Name = (TextView)show.findViewById(R.id.CustomerName);
        TextView Review = (TextView)show.findViewById(R.id.UserReview);


        String name = user_name[position];
        String user_review = review[position];


        User_Name.setText(name);
        Review.setText(user_review);

        return show;
    }
}
