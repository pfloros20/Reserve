package com.example.reserve;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Event_list extends AppCompatActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> myArrayAdapter;

    ListView storelist;
    String[] stores;
    String[] descriptions;
    String[] review_number;
    String[] stars;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
    }
}
