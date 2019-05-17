package com.example.reserve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Start_Page extends AppCompatActivity {

    String[] stores = {"Makina","Molos","Destro"};
    String[] descriptions = {"da best","epic","not a good choice"};
    int[] review_number = {23,99,12};
    float[] stars = {3,5,(5/2)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);

        if(getIntent().hasExtra("ID2")){
            TextView text = (TextView)findViewById(R.id.textView14);
            text.setText(getIntent().getExtras().getString("ID2"));

            ListView storelist = (ListView)findViewById(R.id.storelist);
            /*stores = res.getStringArray(R.array.stores);
            descriptions = res.getStringArray(R.array.descriptions);
            review_number = res.getIntegerArray(R.array.review_number);
            stars = res.getIntegerArray(R.array.stars);*/

            MyAdapter myAdapter = new MyAdapter(this, stores, descriptions, review_number, stars);

            storelist.setAdapter(myAdapter);

        }
    }
}
