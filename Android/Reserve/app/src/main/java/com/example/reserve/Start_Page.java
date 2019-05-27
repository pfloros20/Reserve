package com.example.reserve;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Start_Page extends AppCompatActivity {

    ListView storelist;
    String[] stores;
    String[] descriptions;
    String[] review_number;
    String[] stars;
    String[] address;
    String[] capacity;

    private ListView mDrawerList;
    private ArrayAdapter<String> myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);

        mDrawerList = (ListView)findViewById(R.id.navList);
        addOptions();

        if(getIntent().hasExtra("Username")){

            Resources res = getResources();
            storelist = (ListView)findViewById(R.id.storelist);
            stores = res.getStringArray(R.array.stores);
            descriptions = res.getStringArray(R.array.descriptions);
            review_number = res.getStringArray(R.array.review_number);
            stars = res.getStringArray(R.array.stars);
            address = res.getStringArray(R.array.address);
            capacity = res.getStringArray(R.array.capacity);

            MyAdapter myAdapter = new MyAdapter(this, stores, descriptions, review_number, stars);

            storelist.setAdapter(myAdapter);

            storelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent store_page = new Intent(getApplicationContext(),Store_Page.class);
                    store_page.putExtra("StoreName", stores[position]);
                    store_page.putExtra("Stars", stars[position]);
                    store_page.putExtra("Address", address[position]);
                    store_page.putExtra("Capacity", capacity[position]);
                    startActivity(store_page);
                }
            });

        }
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Start_Page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void addOptions(){
        String[] user_options = { getIntent().getExtras().getString("Username"), "Start Page", "Reservations", "Favourites", "Events", "Reviews", "Log Out", "Communication"};
        myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, user_options);
        mDrawerList.setAdapter(myArrayAdapter);
    }
}
