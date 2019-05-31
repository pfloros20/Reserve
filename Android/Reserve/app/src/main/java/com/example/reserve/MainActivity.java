package com.example.reserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> review_u1 = new ArrayList<String>();
        review_u1.add("3aaaaa");
        review_u1.add("2bbbb");
        ArrayList<String> visited_u1 = new ArrayList<String>();
        visited_u1.add("Molos");
        ArrayList<String> reports_u1 = new ArrayList<String>();

        ArrayList<String> review_u2 = new ArrayList<String>();
        review_u2.add("4aaaa");
        ArrayList<String> visited_u2 = new ArrayList<String>();
        visited_u2.add("Molos");
        ArrayList<String> reports_u2 = new ArrayList<String>();


        final User user1 = new User(0, "george","a", review_u1, visited_u1, reports_u1, 0, 0);
        final User user2 = new User(1, "makis","b", review_u2, visited_u2, reports_u2, 0, 0);

        Button LogBtn = (Button)findViewById(R.id.LogBtn);
        LogBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText Username = (EditText) findViewById(R.id.Username);
                EditText Password = (EditText) findViewById(R.id.Password);

                String username = (Username.getText()).toString();
                String password = (Password.getText()).toString();

                if (username.equalsIgnoreCase(user1.Username) && password.equalsIgnoreCase(user1.Password)) {
                    Intent startIntent = new Intent(getApplicationContext(), Start_Page.class);
                    startIntent.putExtra("Username", user1.Username);
                    startIntent.putExtra("User_ID", user1.ID);
                    startIntent.putExtra("User_Review", user1.Reviews);
                    startIntent.putExtra("User_Visited", user1.Visited);
                    startIntent.putExtra("User_Reports", user1.Reports);
                    startActivity(startIntent);
                }else if (username.equalsIgnoreCase(user2.Username) && password.equalsIgnoreCase(user2.Password)){
                    Intent startIntent = new Intent(getApplicationContext(), Start_Page.class);
                    startIntent.putExtra("Username", user2.Username);
                    startIntent.putExtra("User_ID", user2.ID);
                    startIntent.putExtra("User_Review", user2.Reviews);
                    startIntent.putExtra("User_Visited", user2.Visited);
                    startIntent.putExtra("User_Reports", user2.Reports);
                    startActivity(startIntent);
                }else{
                    Toast.makeText(MainActivity.this,"Wrong name or pass!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
