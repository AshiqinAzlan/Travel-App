package com.example.hoppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class userprofile extends AppCompatActivity {

    LinearLayout l1,l2,l3,l4;
    ImageButton i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        l1 = (LinearLayout) findViewById(R.id.myprofile);
        l2 = (LinearLayout) findViewById(R.id.bookings);
        l3 = (LinearLayout) findViewById(R.id.helpcenter);
        l4 = (LinearLayout) findViewById(R.id.about);
        i1 = (ImageButton) findViewById(R.id.backbutton);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userprofile.this, editprofile.class));
            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userprofile.this, helpCenter.class));
            }
        });

        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userprofile.this, about.class));
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userprofile.this, bookingsDetail.class));
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userprofile.this, home.class));
            }
        });
    }
}