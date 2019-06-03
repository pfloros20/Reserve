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
    ArrayList<Store> stores = new ArrayList<Store>();

    private ListView mDrawerList;
    private ArrayAdapter<String> myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);
        final User user =  new User(getIntent().getExtras().getInt("User_ID"),
                getIntent().getExtras().getString("Username"), " ",
                getIntent().getIntegerArrayListExtra("User_Review"),
                getIntent().getIntegerArrayListExtra("User_Visited"),
                getIntent().getIntegerArrayListExtra("User_Reports"), 0, 0);

        mDrawerList = (ListView)findViewById(R.id.navList);
        addOptions(user.Username, mDrawerList, myArrayAdapter);

        if(getIntent().hasExtra("Username")){

            storelist = (ListView)findViewById(R.id.storelist);


            MyAdapter myAdapter = new MyAdapter(this, Data.stores);

            storelist.setAdapter(myAdapter);

            storelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent store_page = new Intent(getApplicationContext(),Store_Page.class);
                    store_page.putExtra("Store_ID", Data.stores.get(position).ID);
                    store_page.putExtra("StoreName", Data.stores.get(position).Name);
                    store_page.putExtra("StoreStars", Data.stores.get(position).Stars);
                    store_page.putExtra("StoreCapacity", String.valueOf(Data.stores.get(position).Capacity));
                    store_page.putExtra("X", Data.stores.get(position).X);
                    store_page.putExtra("Y", Data.stores.get(position).Y);
                    store_page.putExtra("Tables", Data.stores.get(position).Tables);
                    store_page.putExtra("User_ID", user.ID);
                    store_page.putExtra("Username", user.Username);
                    store_page.putExtra("User_Review", user.Reviews);
                    store_page.putExtra("User_Reports", user.Reports);
                    store_page.putExtra("User_Visited", user.Visited);
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
    @Override
    public void onBackPressed() {}

    private void addOptions(String user, ListView mDrawerList, ArrayAdapter<String> myArrayAdapter){
        String[] user_options = {user, "Start Page", "Reservations", "Favourites", "Events", "Reviews", "Log Out", "Communication"};
        myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, user_options);
        mDrawerList.setAdapter(myArrayAdapter);
    }
}
