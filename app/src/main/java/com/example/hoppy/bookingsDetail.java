package com.example.hoppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class bookingsDetail extends AppCompatActivity {

    Button b1,b2,b3;
    ImageButton i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings_detail);

        b1 = (Button) findViewById(R.id.food);
        b2 = (Button) findViewById(R.id.activity);
        b3 = (Button) findViewById(R.id.homestay);
        i1 = (ImageButton)findViewById(R.id.backbutton);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bookingsDetail.this, userprofile.class));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value="foodbookingdetails";
                Intent i = new Intent(bookingsDetail.this, multiBookings.class);
                i.putExtra("key",value);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value="activitybookingdetails";
                Intent i = new Intent(bookingsDetail.this, multiBookings.class);
                i.putExtra("key",value);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value="homestaybookingdetails";
                Intent i = new Intent(bookingsDetail.this, multiBookings.class);
                i.putExtra("key",value);
                startActivity(i);
            }
        });

    }

}