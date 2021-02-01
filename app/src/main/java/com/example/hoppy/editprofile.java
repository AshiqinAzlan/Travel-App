package com.example.hoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class editprofile extends AppCompatActivity {

    ImageButton i1;
    TextView t1;
    EditText e1;
    DatabaseReference databaseReference;
    FirebaseUser user;
    String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        i1 = (ImageButton) findViewById(R.id.backbutton);
        t1 = (TextView) findViewById(R.id.saveDetails);
        e1 = (EditText) findViewById(R.id.usernamechange);

        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(editprofile.this, userprofile.class));
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                           String username = e1.getText().toString();

                        dataSnapshot.getRef().child(uid).child("username").setValue(username);

                        AlertDialog alertDialog = new AlertDialog.Builder(editprofile.this).create();
                        alertDialog.setTitle("Success");
                        alertDialog.setMessage("Name has succesfully changed");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        startActivity(new Intent(editprofile.this, userprofile.class));
                                    }
                                });
                        alertDialog.show();


//                        Toast.makeText(getApplicationContext(),"Data changed",Toast.LENGTH_LONG);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(),"Network ERROR,Please check your connection",Toast.LENGTH_LONG);
                    }
                });

            }
        });
    }
}