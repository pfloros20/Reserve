package com.example.reserve;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Start_Page extends AppCompatActivity {

    ListView storelist;
    String[] stores;
    String[] descriptions;
    String[] review_number;
    String[] stars ;

    private ListView mDrawerList;
    private ArrayAdapter<String> myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);

        mDrawerList = (ListView)findViewById(R.id.navList);
        addOptions();

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
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Start_Page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void addOptions(){
        String[] user_options = { getIntent().getExtras().getString("ID2"), "Start Page", "Reservations", "Favourites", "Events", "Reviews", "Log Out", "Communication"};
        myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, user_options);
        mDrawerList.setAdapter(myArrayAdapter);
    }
}
