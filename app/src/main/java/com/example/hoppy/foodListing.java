package com.example.hoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class foodListing extends AppCompatActivity {

    GridView g1;
    ArrayList<Food> list;
    foodadpt adapter=null;
    DatabaseReference databaseReference;
    FirebaseUser user;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_listing);
        g1 = (GridView) findViewById(R.id.activitylisting);

        list = new ArrayList<>();
        adapter = new foodadpt(this, R.layout.placestostay, list);
        g1.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Food");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Food homelist = ds.getValue(Food.class);
                    list.add(homelist);
                    Log.i("TEST", String.valueOf(homelist));

                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Network ERROR,Please check your connection", Toast.LENGTH_LONG);
            }
        });


    }
}