package com.example.hoppy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class confirmationpage extends AppCompatActivity {

    ImageView i1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmationpage);
        i1=(ImageView) findViewById(R.id.imageQR);
        b1 = (Button) findViewById(R.id.back);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String fname = extras.getString("fname");
            String lname = extras.getString("lname");
            String mail = extras.getString("mail");
            String num = extras.getString("num");
            String date = extras.getString("date");
            String keyd = extras.getString("keyd");

            String data = fname + " " + lname + " " + mail + " " + num + " " + date + " " + keyd;


        QRGEncoder enc = new QRGEncoder(data,null, QRGContents.Type.TEXT,500);
        try{
            Bitmap qrbit = enc.getBitmap();
            i1.setImageBitmap(qrbit);
        }catch (Exception e){

        }
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(confirmationpage.this)
                        .setTitle("Alert")
                        .setMessage("Have you screenshot the QR code ? Press 'Cancel' if you haven't. If you already screenshot, proceed clicking on 'OK' " )

                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(confirmationpage.this, home.class));
                            }
                        })
                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }
        });
    }
}