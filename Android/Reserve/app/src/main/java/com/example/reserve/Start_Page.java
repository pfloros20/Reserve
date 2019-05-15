package com.example.reserve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Start_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);

        if(getIntent().hasExtra("ID2")){
            TextView text = (TextView)findViewById(R.id.textView14);
            text.setText(getIntent().getExtras().getString("ID2"));

        }
    }
}
