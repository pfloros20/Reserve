package com.example.reserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                String user = "a";
                String pass = "a";

                if (username.equalsIgnoreCase(user) && password.equalsIgnoreCase(pass)) {
                    Intent startIntent = new Intent(getApplicationContext(), Start_Page.class);
                    startIntent.putExtra("Username", username);
                    startActivity(startIntent);
                }else{
                    Toast.makeText(MainActivity.this,"Wrong name or pass!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
