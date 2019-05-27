package com.example.reserve;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class Store_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store__page);

        final boolean favourite;

        LinearLayout gallery = (LinearLayout)findViewById(R.id.gallery);

        LayoutInflater inflater = LayoutInflater.from(this);

        for(int i=0; i<6;i++) {
            View view = inflater.inflate(R.layout.gallery_images, gallery, false);

            ImageView image = view.findViewById(R.id.imageView);
            image.setImageResource(R.drawable.ic_launcher_background);

            gallery.addView(view);
        }


        TextView Store_name = (TextView)findViewById(R.id.StoreName);
        RatingBar rating = (RatingBar)findViewById(R.id.Rating);
        TextView Store_address = (TextView)findViewById(R.id.StoreAddress);
        TextView Store_capacity = (TextView)findViewById(R.id.Capacity);
        final ImageButton favouriteOFF = (ImageButton)findViewById(R.id.favouriteOFF);
        final ImageButton favouriteON = (ImageButton)findViewById(R.id.favouriteON);

        String Store_Name = getIntent().getExtras().getString("StoreName");
        float stars = Float.parseFloat(getIntent().getExtras().getString("Stars"));
        String Store_Address = getIntent().getExtras().getString("Address");
        String Store_Capacity = getIntent().getExtras().getString("Capacity");

        //if(favourite == false)
        favouriteON.setVisibility(View.INVISIBLE);

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

    }
}
