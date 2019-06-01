package com.example.reserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class reservation_page extends AppCompatActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> myArrayAdapter;
    ListView storelist;
    ArrayList<Integer> tableid = new ArrayList<Integer>();
    ArrayList<Integer> table_cap = new ArrayList<Integer>();
    ArrayList<String> table_availability = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_page);

        final ArrayList<Integer> Store_tables = getIntent().getIntegerArrayListExtra("Store_Tables");

        String Store_Name = getIntent().getStringExtra("Store_Name");
        String Capacity = getIntent().getStringExtra("Capacity");
        String user = getIntent().getStringExtra("User");

        Table table1 = new Table(0,0,4,"Free");
        Table table2 = new Table(1,0,4,"Booked");
        Table table3 = new Table(2,0,6,"Free");
        Table table4 = new Table(3,0,4,"Free");
        Table table5 = new Table(4,0,2,"Taken");

        tableid.add(table1.ID);
        tableid.add(table2.ID);
        tableid.add(table3.ID);
        tableid.add(table4.ID);
        tableid.add(table5.ID);
        table_cap.add(table1.Capacity);
        table_cap.add(table2.Capacity);
        table_cap.add(table3.Capacity);
        table_cap.add(table4.Capacity);
        table_cap.add(table5.Capacity);
        table_availability.add(table1.Availability);
        table_availability.add(table2.Availability);
        table_availability.add(table3.Availability);
        table_availability.add(table4.Availability);
        table_availability.add(table5.Availability);



        TextView StoreName = (TextView)findViewById(R.id.Storename);
        TextView StoreCapacity = (TextView)findViewById(R.id.Capacity);
        TextView Datetext =(TextView)findViewById(R.id.textView1);
        EditText Date = (EditText)findViewById(R.id.datetext);
        Button resBtn = (Button)findViewById(R.id.reserveBtn);
        Button backBtn = (Button)findViewById(R.id.backBtn);
        mDrawerList = (ListView)findViewById(R.id.navList);
        storelist = (ListView)findViewById(R.id.table_list);

        addOptions(user, mDrawerList, myArrayAdapter);

        MyThirdAdapter mythirdAdapter = new MyThirdAdapter(this, tableid, table_cap, table_availability);

        storelist.setAdapter(mythirdAdapter);

        StoreName.setText(Store_Name);
        StoreCapacity.setText(Capacity+"%");
        Datetext.setText("Date:");
        String date = Date.getText().toString();

        storelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(reservation_page.this, "Saved current Table.", Toast.LENGTH_SHORT).show();
            }
        });

        resBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(reservation_page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(reservation_page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();
            }
        });

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
                    Toast.makeText(reservation_page.this, "Not implemented yet!", Toast.LENGTH_SHORT).show();
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
