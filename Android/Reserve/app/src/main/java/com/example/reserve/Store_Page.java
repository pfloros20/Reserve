package com.example.reserve;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Store_Page extends AppCompatActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> myArrayAdapter;
    String[] users;
    String[] reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store__page);

        final boolean favourite;
        mDrawerList = (ListView)findViewById(R.id.navList);

        Resources res = getResources();
        users = res.getStringArray(R.array.users);
        reviews = res.getStringArray(R.array.reviews);
        final String user = getIntent().getExtras().getString("User");


        addOptions(user, mDrawerList, myArrayAdapter);

        LinearLayout gallery = (LinearLayout)findViewById(R.id.gallery);

        LayoutInflater inflater = LayoutInflater.from(this);

        for(int i=0; i<6;i++) {
            View view = inflater.inflate(R.layout.gallery_images, gallery, false);

            ImageView image = view.findViewById(R.id.imageView);
            image.setImageResource(R.drawable.ic_launcher_background);

            gallery.addView(view);
        }

        ListView storelist = (ListView)findViewById(R.id.Reviewlist);
        TextView Store_name = (TextView)findViewById(R.id.StoreName);
        RatingBar rating = (RatingBar)findViewById(R.id.Rating);
        TextView Store_address = (TextView)findViewById(R.id.StoreAddress);
        final TextView Store_capacity = (TextView)findViewById(R.id.Capacity);
        final ImageButton favouriteOFF = (ImageButton)findViewById(R.id.favouriteOFF);
        final ImageButton favouriteON = (ImageButton)findViewById(R.id.favouriteON);
        ImageView Store_map = (ImageView)findViewById(R.id.StoreMap);
        Button reservation_btn = (Button)findViewById(R.id.ReservationBtn);
        Button events_btn = (Button)findViewById(R.id.EventsBtn);
        Button menu_btn = (Button)findViewById(R.id.MenuBtn);
        Button shedule_btn = (Button)findViewById(R.id.SheduleBtn);

        Store_map.setImageResource(R.drawable.store);
        final String Store_Name = getIntent().getStringExtra("StoreName");
        float stars = Float.parseFloat(getIntent().getStringExtra("StoreStars"));
        String Store_Address = getIntent().getStringExtra("StoreAddress");
        final String Store_Capacity = getIntent().getStringExtra("StoreCapacity");
        final ArrayList<Integer> Store_tables = getIntent().getIntegerArrayListExtra("Tables");

        MySecondAdapter mySAdapter = new MySecondAdapter(this, users, reviews);
        storelist.setAdapter(mySAdapter);

        //if(favourite == false)
        favouriteON.setVisibility(View.INVISIBLE);
        //map

        if(getIntent().hasExtra("StoreName")){
            Store_name.setText(Store_Name);
            rating.setRating(stars);
            Store_address.setText(Store_Address);
            Store_capacity.setText(Store_Capacity+"%");


            favouriteOFF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    favouriteOFF.setVisibility(View.INVISIBLE);
                    favouriteON.setVisibility(View.VISIBLE);
                   // favourite = true;
                }
            });
            favouriteON.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    favouriteON.setVisibility(View.INVISIBLE);
                    favouriteOFF.setVisibility(View.VISIBLE);
                    //favourite = false;
                }
            });

        }
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == 1) {
                    Intent change = new Intent(getApplicationContext(), Start_Page.class);
                    startActivity(change);
                }else if(id == 6){
                    Intent change = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(change);
                }else{
                    Toast.makeText(Store_Page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reservation_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent change = new Intent(getApplicationContext(), reservation_page.class);
                change.putIntegerArrayListExtra("Store_Tables",Store_tables);
                change.putExtra("User", user);
                change.putExtra("Store_Name", Store_Name);
                change.putExtra("Capacity", Store_Capacity);
                startActivity(change);
            }
        });

        events_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(Store_Page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();
            }
        });

        menu_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(Store_Page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();            }
        });

        shedule_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(Store_Page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();            }
        });
    }
    private void addOptions(String user, ListView mDrawerList, ArrayAdapter<String> myArrayAdapter){
        String[] user_options = {user, "Start Page", "Reservations", "Favourites", "Events", "Reviews", "Log Out", "Communication"};
        myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, user_options);
        mDrawerList.setAdapter(myArrayAdapter);
    }
}
