package com.example.reserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Start_Page extends AppCompatActivity {

    ListView storelist;
    ArrayList<String> stores = new  ArrayList<String>();
    ArrayList<String> descriptions = new  ArrayList<String>();
    ArrayList<String> review_number = new  ArrayList<String>();
    ArrayList<String> stars = new  ArrayList<String>();
    ArrayList<String> capacity = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<Float> axis_x = new ArrayList<Float>();
    ArrayList<Float> axis_y = new ArrayList<Float>();

    private ListView mDrawerList;
    private ArrayAdapter<String> myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);
        final User user =  new User(getIntent().getExtras().getInt("User_ID"), getIntent().getExtras().getString("Username"), " ", getIntent().getStringArrayListExtra("User_Review"), getIntent().getStringArrayListExtra("User_Visited"), getIntent().getStringArrayListExtra("User_Reports"), 0, 0);

        ArrayList<String> store =new ArrayList<String>();
        store.add("Makina");
        store.add("Molos");
        store.add("Destro");

        ArrayList<Integer> store1_tables = new ArrayList<Integer>();
        for (int i=0; i<6;i++) {
            store1_tables.add(i);
        }
        ArrayList<String> store1_events = new ArrayList<String>();
        ArrayList<Integer> store1_reviews = new ArrayList<Integer>();
        for (int i=0; i<2;i++) {
            store1_reviews.add(i);
        }
        ArrayList<Integer> store1_reservations = new ArrayList<Integer>();
        for (int i=0; i<8;i=i+2) {
            store1_reservations.add(i);
        }
        ArrayList<Integer> store2_tables = new ArrayList<Integer>();
        for (int i=7; i<15;i++) {
            store2_tables.add(i);
        }
        ArrayList<String> store2_events = new ArrayList<String>();
        ArrayList<Integer> store2_reviews = new ArrayList<Integer>();
        for (int i=2; i<5;i++) {
            store2_reviews.add(i);
        }
        ArrayList<Integer> store2_reservations = new ArrayList<Integer>();
        for (int i=1; i<8;i=i+2) {
            store2_reservations.add(i);
        }
        ArrayList<Integer> store3_tables = new ArrayList<Integer>();
        for (int i=8; i<16;i++) {
            store3_tables.add(i);
        }
        ArrayList<String> store3_events = new ArrayList<String>();
        ArrayList<Integer> store3_reviews = new ArrayList<Integer>();
        for (int i=5; i<9;i++) {
            store3_reviews.add(i);
        }
        ArrayList<Integer> store3_reservations = new ArrayList<Integer>();
        for (int i=10; i<18;i=i+2) {
            store3_reservations.add(i);
        }

        final Owner owner1 = new Owner(0,"Mixalis","a", store);

        final Store store1 = new Store(0,owner1.Stores.get(0), owner1.ID, "Agiou Andreou 26","3.5",33, 10, "da best", true, "Restaurant",0,0, store1_tables, store1_events, store1_reviews, store1_reservations);
        final Store store2 = new Store(0,owner1.Stores.get(1), owner1.ID, "Agiou Nikolaou 0","5",40, 2, "epic", true, "Restaurant",0,0, store2_tables, store2_events, store2_reviews, store2_reservations);
        final Store store3 = new Store(0,owner1.Stores.get(2), owner1.ID, "Korinthou 208","2.5",27, 15, "not so bad", true, "Restaurant",0,0, store3_tables, store3_events, store3_reviews, store3_reservations);

        mDrawerList = (ListView)findViewById(R.id.navList);
        addOptions(user.Username, mDrawerList, myArrayAdapter);

        if(getIntent().hasExtra("Username")){

            storelist = (ListView)findViewById(R.id.storelist);
            stores.add(store1.Name);
            stores.add(store2.Name);
            stores.add(store3.Name);
            descriptions.add(store1.Description);
            descriptions.add(store2.Description);
            descriptions.add(store3.Description);
            review_number.add(String.valueOf(store1.Reviews.size()));
            review_number.add(String.valueOf(store2.Reviews.size()));
            review_number.add(String.valueOf(store3.Reviews.size()));
            stars.add(store1.Stars);
            stars.add(store2.Stars);
            stars.add(store3.Stars);
            address.add(store1.Address);
            address.add(store2.Address);
            address.add(store3.Address);
            capacity.add(String.valueOf(store1.Capacity));
            capacity.add(String.valueOf(store2.Capacity));
            capacity.add(String.valueOf(store3.Capacity));
            axis_x.add(store1.X);
            axis_x.add(store2.X);
            axis_x.add(store3.X);
            axis_y.add(store1.Y);
            axis_y.add(store2.Y);
            axis_y.add(store3.Y);

            MyAdapter myAdapter = new MyAdapter(this, stores, descriptions, review_number, stars);

            storelist.setAdapter(myAdapter);

            storelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent store_page = new Intent(getApplicationContext(),Store_Page.class);
                    store_page.putExtra("StoreName", stores.get(position));
                    store_page.putExtra("StoreStars", stars.get(position));
                    store_page.putExtra("StoreAddress", address.get(position));
                    store_page.putExtra("StoreCapacity", capacity.get(position));
                    store_page.putExtra("X", axis_x.get(position));
                    store_page.putExtra("Y", axis_y.get(position));
                    store_page.putExtra("User", user.Username);
                    startActivity(store_page);
                }
            });

        }
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == 1) {
                    Toast.makeText(Start_Page.this, "You are in the start page", Toast.LENGTH_SHORT).show();
                }else if(id == 6){
                    Intent change = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(change);
                }else{
                    Toast.makeText(Start_Page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void addOptions(String user, ListView mDrawerList, ArrayAdapter<String> myArrayAdapter){
        String[] user_options = {user, "Start Page", "Reservations", "Favourites", "Events", "Reviews", "Log Out", "Communication"};
        myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, user_options);
        mDrawerList.setAdapter(myArrayAdapter);
    }
}
