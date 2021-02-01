package com.example.hoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class multiBookings extends AppCompatActivity {

    GridView g1;
    ArrayList<bookingobject> list;
    detailzadpt adapter=null;
    DatabaseReference databaseReference;
    //FirebaseAuth mAuth;
    FirebaseUser user;

    String uid;
    ImageButton i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_bookings);

        g1 = (GridView) findViewById(R.id.grid);
        i1 = (ImageButton) findViewById(R.id.backbutton);

        list = new ArrayList<>();
        adapter = new detailzadpt(this, R.layout.bookingdetailz, list);
        g1.setAdapter(adapter);

        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(multiBookings.this, bookingsDetail.class));
            }
        });


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
            databaseReference = FirebaseDatabase.getInstance().getReference().child(value).child(uid);


//        databaseReference = FirebaseDatabase.getInstance().getReference().child(va);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    bookingobject homelist = ds.getValue(bookingobject.class);
                    list.add(homelist);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Network ERROR,Please check your connection",Toast.LENGTH_LONG);
            }
        });
    }
    }
}