package com.example.reserve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MySecondAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    ArrayList<User> users;
    ArrayList<Review> reviews = new ArrayList<Review>();


    public MySecondAdapter(Context a, ArrayList<User> users, ArrayList<Review> reviews, int Store_ID){
        this.users = users;
        for(int i=0;i<reviews.size();i++) {
            if(reviews.get(i).Store_ID == Store_ID)
                this.reviews.add(reviews.get(i));
        }
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return reviews.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
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

        String name = users.get(reviews.get(position).SubmittedBy).Username;
        String user_review = reviews.get(position).Description;


        User_Name.setText(name);
        Review.setText(user_review);

        return show;
    }
}
