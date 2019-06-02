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
    ArrayList<Table> tables = new ArrayList<Table>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_page);

        final ArrayList<Integer> Store_tables = getIntent().getIntegerArrayListExtra("Store_Tables");

        String Store_Name = getIntent().getStringExtra("Store_Name");
        String Capacity = getIntent().getStringExtra("Capacity");
        final User user =  new User(getIntent().getExtras().getInt("User_ID"),
                getIntent().getExtras().getString("Username"), " ",
                getIntent().getIntegerArrayListExtra("User_Review"),
                getIntent().getIntegerArrayListExtra("User_Visited"),
                getIntent().getIntegerArrayListExtra("User_Reports"), 0, 0);

        tables.add(new Table(0,0,4,"Free"));
        tables.add(new Table(1,0,4,"Booked"));
        tables.add(new Table(2,0,6,"Free"));
        tables.add(new Table(3,0,4,"Free"));
        tables.add(new Table(4,0,2,"Taken"));

        TextView StoreName = (TextView)findViewById(R.id.Storename);
        TextView StoreCapacity = (TextView)findViewById(R.id.Capacity);
        TextView Datetext =(TextView)findViewById(R.id.textView1);
        EditText Date = (EditText)findViewById(R.id.datetext);
        Button resBtn = (Button)findViewById(R.id.reserveBtn);
        Button backBtn = (Button)findViewById(R.id.backBtn);
        mDrawerList = (ListView)findViewById(R.id.navList);
        storelist = (ListView)findViewById(R.id.table_list);

        addOptions(user.Username, mDrawerList, myArrayAdapter);

        MyThirdAdapter mythirdAdapter = new MyThirdAdapter(this, tables);

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
