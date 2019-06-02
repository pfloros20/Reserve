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
    public Table res_table = new Table(0,0,4,null);
    ListView storelist;
    ArrayList<Table> tables = new ArrayList<Table>();
    public int location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_page);

        final ArrayList<Integer> Store_tables = getIntent().getIntegerArrayListExtra("Store_Tables");

        String Store_Name = getIntent().getStringExtra("Store_Name");
        final int Store_ID = getIntent().getIntExtra("Store_ID", -1);
        String Capacity = getIntent().getStringExtra("Capacity");
        final User user =  new User(getIntent().getExtras().getInt("User_ID"),
                getIntent().getExtras().getString("Username"), " ",
                getIntent().getIntegerArrayListExtra("User_Review"),
                getIntent().getIntegerArrayListExtra("User_Visited"),
                getIntent().getIntegerArrayListExtra("User_Reports"), 0, 0);


        TextView StoreName = (TextView)findViewById(R.id.Storename);
        TextView StoreCapacity = (TextView)findViewById(R.id.Capacity);
        TextView Datetext =(TextView)findViewById(R.id.textView1);
        EditText Date = (EditText)findViewById(R.id.datetext);
        Button resBtn = (Button)findViewById(R.id.reserveBtn);
        Button backBtn = (Button)findViewById(R.id.backBtn);
        mDrawerList = (ListView)findViewById(R.id.navList);
        storelist = (ListView)findViewById(R.id.table_list);

        addOptions(user.Username, mDrawerList, myArrayAdapter);

        for (int i=0; i<Data.tables.size();i++) {
            if(Data.tables.get(i).Store == Store_ID)
                tables.add(Data.tables.get(i));
        }

        final MyThirdAdapter mythirdAdapter = new MyThirdAdapter(this, tables, Store_ID);

        storelist.setAdapter(mythirdAdapter);

        StoreName.setText(Store_Name);
        StoreCapacity.setText(Capacity+"%");
        Datetext.setText("Date:");
        String date = Date.getText().toString();

        storelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(("FREE".equals(tables.get(position).Availability)) && (Store_ID == tables.get(position).Store)){
                    res_table = tables.get(position);
                    location = position;
                    Toast.makeText(reservation_page.this, "Saved selected table!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(reservation_page.this, "You can't reserve this table!", Toast.LENGTH_SHORT).show();
            }
        });

        resBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(res_table.Availability != null) {
                    res_table.updateAvailability("BOOKED");
                    tables.remove(location);
                    tables.add(location, res_table);

                    mythirdAdapter.tables = tables;
                    storelist.setAdapter(mythirdAdapter);
                }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == 1) {
                    Intent change = new Intent(getApplicationContext(), Start_Page.class);
                    change.putExtra("User_ID", user.ID);
                    change.putExtra("Username", user.Username);
                    change.putExtra("User_Review", user.Reviews);
                    change.putExtra("User_Reports", user.Reports);
                    change.putExtra("User_Visited", user.Visited);
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
