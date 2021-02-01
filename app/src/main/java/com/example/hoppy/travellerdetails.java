package com.example.hoppy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class travellerdetails extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3,e4,e5;
    CheckBox c1;
    DatabaseReference dr;
    public String fname,lname,mail,num,date,keydetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travellerdetails);


        b1 =(Button) findViewById(R.id.confirm);
        e1 = (EditText)findViewById(R.id.firstname);
        e2 = (EditText)findViewById(R.id.lastname);
        e3 = (EditText)findViewById(R.id.email);
        e4 = (EditText)findViewById(R.id.phone);
        e5 = (EditText)findViewById(R.id.date);
        c1 = (CheckBox) findViewById(R.id.checkbox);

        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        dr = FirebaseDatabase.getInstance().getReference("homestaybookingdetails").child(currentuser);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 fname = e1.getText().toString();
                 lname = e2.getText().toString();
                 mail = e3.getText().toString();
                 num = e4.getText().toString();
                 date = e5.getText().toString();

                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String value = extras.getString("key1");


                    keydetails = value;

                }
                Log.i("gdfgs",keydetails);

                if(!fname.isEmpty() ||!lname.isEmpty() ||!mail.isEmpty() ||!num.isEmpty() ||!date.isEmpty()){

                    String currentuser = dr.push().getKey();
                    Travellers travel = new Travellers(fname,lname,mail,num,date,keydetails);
                    dr.child(currentuser).setValue(travel);
                    AlertDialog alertDialog = new AlertDialog.Builder(travellerdetails.this).create();
                    alertDialog.setTitle("Success");
                    alertDialog.setMessage("Booking details successfully entered");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(travellerdetails.this, confirmationpage.class);
                                    i.putExtra("fname",fname);
                                    i.putExtra("lname",lname);
                                    i.putExtra("mail",mail);
                                    i.putExtra("num",num);
                                    i.putExtra("date",date);
                                    i.putExtra("keyd",keydetails);
                                    startActivity(i);
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                }
                else{
                    Toast.makeText(travellerdetails.this,"Fields shall not be empty",Toast.LENGTH_LONG);
                }

            }
        });

    }
}