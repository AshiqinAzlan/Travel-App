package com.example.hoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.synnapps.carouselview.CarouselView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class home extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper v1,v2,v3;
    TextView t1;
    DatabaseReference databaseReference;
    FirebaseUser user;
    TextView i1;
    ImageButton activ,hotel,food;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        v1 = (ViewFlipper) findViewById(R.id.popularDestination);
        v2 = (ViewFlipper) findViewById(R.id.topActivities);
        v3 = (ViewFlipper) findViewById(R.id.foodies);
        t1 = (TextView) findViewById(R.id.username);
        i1 = (TextView) findViewById(R.id.userprofile);
//        ii1 = (ImageButton) findViewById(R.id.destinationSearch);
        hotel = (ImageButton) findViewById(R.id.hotels);
        activ = (ImageButton) findViewById(R.id.activities);
        food = (ImageButton) findViewById(R.id.foodie);

        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String usernm = snapshot.child("username").getValue(String.class);
                t1.setText(usernm);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Network ERROR,Please check your connection",Toast.LENGTH_LONG);
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, userprofile.class));
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, bookinglisting.class));
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, foodListing.class));
            }
        });


        activ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, activitieslisting.class));
            }
        });


        int destination [] = {R.drawable.cameron, R.drawable.langkawi,R.drawable.sabah};
        int activities [] = {R.drawable.legoland, R.drawable.skyway,R.drawable.aquaria};
        int food [] = {R.drawable.paramount, R.drawable.atmosphere,R.drawable.pasta};


        v1.setOnClickListener(this);
        v2.setOnClickListener(this);
        v3.setOnClickListener(this);

        for (int i = 0; i<activities.length; i++){
            flipperImage1(activities[i]);
            Log.i("Check", String.valueOf(activities[i]));
        }

        for (int i = 0; i<destination.length; i++){
            flipperImage(destination[i]);
            Log.i("Check", String.valueOf(destination[i]));
        }
        for (int i = 0; i<food.length; i++){
            flipperImage2(food[i]);
            Log.i("Check", String.valueOf(food[i]));
        }

    }


    @Override
    public void onClick(View v) {
        v1.startFlipping();
        v1.setFlipInterval(2000);
        v2.startFlipping();
        v2.setFlipInterval(2000);
        v3.startFlipping();
        v3.setFlipInterval(2000);
    }
    public void flipperImage(int destination){
        ImageView imgv = new ImageView(this);
        imgv.setBackgroundResource(destination);

        v1.addView(imgv);


    }
    public void flipperImage1(int destination){
        ImageView imgv = new ImageView(this);
        imgv.setBackgroundResource(destination);

        v2.addView(imgv);
    }
    public void flipperImage2(int destination){
        ImageView imgv = new ImageView(this);
        imgv.setBackgroundResource(destination);

        v3.addView(imgv);
    }
}
