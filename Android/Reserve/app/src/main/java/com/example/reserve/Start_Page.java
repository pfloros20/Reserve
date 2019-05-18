package com.example.reserve;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class Start_Page extends AppCompatActivity {

    ListView storelist;
    String[] stores;
    String[] descriptions;
    String[] review_number;
    String[] stars ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);

        if(getIntent().hasExtra("ID2")){
            TextView text = (TextView)findViewById(R.id.textView14);
            text.setText(getIntent().getExtras().getString("ID2"));


            Resources res = getResources();
            storelist = (ListView)findViewById(R.id.storelist);
            stores = res.getStringArray(R.array.stores);
            descriptions = res.getStringArray(R.array.descriptions);
            review_number = res.getStringArray(R.array.review_number);
            stars = res.getStringArray(R.array.stars);

            MyAdapter myAdapter = new MyAdapter(this, stores, descriptions, review_number, stars);

            storelist.setAdapter(myAdapter);

        }
    }
}
