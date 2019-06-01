package com.example.reserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button LogBtn = (Button)findViewById(R.id.LogBtn);
        LogBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText Username = (EditText) findViewById(R.id.Username);
                EditText Password = (EditText) findViewById(R.id.Password);

                String username = (Username.getText()).toString();
                String password = (Password.getText()).toString();

                boolean found = false;
                for(int i = 0; i<Data.users.size();i++) {
                    Log.w("We are in", String.valueOf(Data.users.get(i).Username));
                    if (username.equalsIgnoreCase(Data.users.get(i).Username) && password.equalsIgnoreCase(Data.users.get(i).Password)) {
                        found = true;
                        Intent startIntent = new Intent(getApplicationContext(), Start_Page.class);
                        startIntent.putExtra("Username", Data.users.get(i).Username);
                        startIntent.putExtra("User_ID", Data.users.get(i).ID);
                        startIntent.putExtra("User_Review", Data.users.get(i).Reviews);
                        startIntent.putExtra("User_Visited", Data.users.get(i).Visited);
                        startIntent.putExtra("User_Reports", Data.users.get(i).Reports);
                        startActivity(startIntent);
                        break;
                    }
                }
                if(!found)
                    Toast.makeText(MainActivity.this,"Wrong name or pass!",Toast.LENGTH_LONG).show();

            }
        });


    }
}
