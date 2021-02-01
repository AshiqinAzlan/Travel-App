package com.example.hoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class createAccount extends AppCompatActivity {

    TextView t1;
    EditText e1,e2,e3;
    FirebaseAuth mAuth;
    Button b1;
    DatabaseReference dr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        e1= (EditText) findViewById(R.id.email);
        e2= (EditText) findViewById(R.id.password);
        e3= (EditText) findViewById(R.id.username);
        t1 = (TextView) findViewById(R.id.loginCreate);
        b1 = (Button) findViewById(R.id.submit);
        mAuth=FirebaseAuth.getInstance();
        dr = FirebaseDatabase.getInstance().getReference("Users");

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createAccount.this, login.class));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    private void Register() {
        final String email = e1.getText().toString();
        final String password = e2.getText().toString();
        final String username = e3.getText().toString();

        if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
            Toast.makeText(createAccount.this, "Please ensure all details are filled in",
                    Toast.LENGTH_LONG).show();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Users user = new Users(email, password,username);
                                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                  @Override
                                                                                  public void onComplete(@NonNull Task<Void> task) {
                                                                                      if (task.isSuccessful()) {
                                                                                          startActivity(new Intent(createAccount.this, login.class));
                                                                                          Toast.makeText(createAccount.this, "Register Successful!",
                                                                                                  Toast.LENGTH_LONG).show();

                                                                                      } else {
                                                                                          Toast.makeText(createAccount.this, "Network Error!Register fail",
                                                                                                  Toast.LENGTH_LONG).show();
                                                                                      }
                                                                                  }
                                                                              }

                                );
                            }
                            else{
                                Toast.makeText(createAccount.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }


                        }});
        }
    }
}