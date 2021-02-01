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

public class activitieslisting extends AppCompatActivity {

    GridView g1;
    ArrayList<Activities> list;
    activitiesadpt adapter = null;
    DatabaseReference databaseReference;
    //FirebaseAuth mAuth;
    FirebaseUser user;

    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitieslisting);
        g1 = (GridView) findViewById(R.id.activitylisting);

        list = new ArrayList<>();
        adapter = new activitiesadpt(this, R.layout.placestostay, list);
        g1.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Activities");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Activities homelist = ds.getValue(Activities.class);
                    list.add(homelist);
                    Log.i("TEST", String.valueOf(homelist));

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