package com.example.hoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class activitiesinfo extends AppCompatActivity {

    ImageView i1;
    TextView t1,t2,t3;
    Button b1;
    DatabaseReference databaseReference;
    public String key;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitiesinfo);
        t1 =(TextView) findViewById(R.id.price);
        i1 = (ImageView) findViewById(R.id.image);
        t2 =(TextView) findViewById(R.id.desc);
        b1 = (Button) findViewById(R.id.book);
        t3 = (TextView) findViewById(R.id.pricee);


        Bundle b = new Bundle();
        b = getIntent().getExtras();
        key = b.getString("Key");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activitiesinfo.this, activistdetails.class);
                i.putExtra("key1",key);
                startActivity(i);
            }
        });
      

        databaseReference = FirebaseDatabase.getInstance().getReference("Activities").child(key);
        Query query = FirebaseDatabase.getInstance().getReference("Activities").orderByChild(key);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String placename = snapshot.child("location").getValue(String.class);
                String price = snapshot.child("price").getValue(String.class);


                String img = snapshot.child("imageUrl").getValue(String.class);
                Picasso.with(activitiesinfo.this)
                        .load(img)
                        .placeholder(R.mipmap.ic_launcher)
                        .fit()
                        .centerCrop()
                        .into(i1);
                t1.setText(placename);
                String details = snapshot.child("details").getValue(String.class);
                t2.setText(details);
                t3.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Network ERROR,Please check your connection",Toast.LENGTH_LONG);
            }
        });


    }
}